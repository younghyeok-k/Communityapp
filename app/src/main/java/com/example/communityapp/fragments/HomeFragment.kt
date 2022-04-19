package com.example.communityapp.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.communityapp.R
import com.example.communityapp.homePage.InfiniteAdapter
import com.example.communityapp.homePage.homeboardRVAdapter
import com.example.communityapp.board.BoardModel
import com.example.communityapp.board.BoardinsideActivity
import com.example.communityapp.contentlist.BookmarkRVAdapter
import com.example.communityapp.contentlist.ContentListActivity
import com.example.communityapp.contentlist.ContentModel
import com.example.communityapp.databinding.FragmentHomeBinding
import com.example.communityapp.homePage.HomeContentRVAdapter
import com.example.communityapp.utills.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class HomeFragment : Fragment(){
    // TODO: Rename and change types of parameters
    private val TAG = HomeFragment::class.java.simpleName


    private val boardkeyList = mutableListOf<String>()
    //board
    private lateinit var boardRVAdapter: homeboardRVAdapter
    private val boarddataList = mutableListOf<BoardModel>()

// banner
    private var numBanner = 3 // 배너 갯수
    private var currentPosition = Int.MAX_VALUE / 2
    private var myHandler = MyHandler()
    private val intervalTime = 1500.toLong()

    //contnent
    val bookmarkIdList = mutableListOf<String>()
    val items = ArrayList<ContentModel>()
    val itemKeyList = ArrayList<String>()

    lateinit var rvAdapter: HomeContentRVAdapter
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)



        binding.tiptap.setOnClickListener {

            it.findNavController().navigate(R.id.action_homeFragment_to_tipFragment)

        }

        binding.talktap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_talkFragment)
        }

        binding.bookmarktap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_bookmarkFragment)
        }
        binding.info.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_myinfo)
        }

        binding.viewPagerBanner.adapter= InfiniteAdapter(getBannerList())
        binding.viewPagerBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPagerBanner.setCurrentItem(currentPosition, false)
        binding.textViewTotalBanner.text = numBanner.toString()


        binding.viewPagerBanner.apply {
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.textViewCurrentBanner.text = "${(position % 3) + 1}" // 여기서도 %3
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        // 뷰페이저에서 손 떼었을때 / 뷰페이저 멈춰있을 때
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // 뷰페이저 움직이는 중
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }

        // board
        boardRVAdapter = homeboardRVAdapter(boarddataList)
        binding.homeboard.adapter = boardRVAdapter


        binding.homeboard.setOnItemClickListener { parent, view, position, id ->


            val intent = Intent(context, BoardinsideActivity::class.java)
            intent.putExtra("key",boardkeyList[position])
            startActivity(intent)


        }

        getFBBoardData()
        //Tipmenu


        binding.category1.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category","category1")
            startActivity(intent)
        }
        binding.category2.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category","category2")
            startActivity(intent)
        }

        binding.category3.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category","category3")
            startActivity(intent)
        }

        binding.category4.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category","category4")
            startActivity(intent)
        }

        binding.category5.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category","category5")
            startActivity(intent)
        }
        binding.category6.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category","category6")
            startActivity(intent)
        }

        binding.category7.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category","category7")
            startActivity(intent)
        }
        binding.category8.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category","category8")
            startActivity(intent)
        }



        //content

        rvAdapter = HomeContentRVAdapter(requireContext(), items, itemKeyList )


        val rv: RecyclerView = binding.rvMain
        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(requireContext(),1)


        getCategoryData()
        return binding.root
    }

    private fun getCategoryData() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (dataModel in dataSnapshot.children) {

                    Log.d(TAG, dataModel.toString())
                    val item = dataModel.getValue(ContentModel::class.java)

                        items.add(item!!)
                        itemKeyList.add(dataModel.key.toString())


                }
                items.reverse()
                itemKeyList.reverse()
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.category1.addValueEventListener(postListener)
        FBRef.category2.addValueEventListener(postListener)
        FBRef.category3.addValueEventListener(postListener)
        FBRef.category4.addValueEventListener(postListener)
        FBRef.category5.addValueEventListener(postListener)
        FBRef.category6.addValueEventListener(postListener)
        FBRef.category7.addValueEventListener(postListener)
        FBRef.category8.addValueEventListener(postListener)

    }

    private fun getFBBoardData() {

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                boarddataList.clear()
                for (dataModel in dataSnapshot.children) {
                    val item = dataModel.getValue(BoardModel::class.java)
                    boarddataList.add(item!!)
                    boardkeyList.add(dataModel.key.toString())

                }
                Log.d(TAG, boarddataList.toString())
                boardkeyList.reverse()
                boarddataList.reverse()

                boardRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }

        FBRef.boardRef.addValueEventListener(postListener)

    }



    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0) // 이거 안하면 핸들러가 1개, 2개, 3개 ... n개 만큼 계속 늘어남
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // intervalTime 만큼 반복해서 핸들러를 실행하게 함
    }

    private fun autoScrollStop(){
        myHandler.removeMessages(0) // 핸들러를 중지시킴
    }
    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {
                binding.viewPagerBanner.setCurrentItem(++currentPosition, true) // 다음 페이지로 이동
                autoScrollStart(intervalTime) // 스크롤을 계속 이어서 한다.
            }
        }
    }

    // 다른 페이지 갔다가 돌아오면 다시 스크롤 시작
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    // 다른 페이지로 떠나있는 동안 스크롤이 동작할 필요는 없음. 정지
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

    private fun getBannerList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    }


}