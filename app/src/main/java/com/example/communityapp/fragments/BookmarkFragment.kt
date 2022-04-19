package com.example.communityapp.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.communityapp.R
import com.example.communityapp.contentlist.BookmarkRVAdapter
import com.example.communityapp.contentlist.ContentModel
import com.example.communityapp.databinding.FragmentBookmarkBinding
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

// TODO: Rename parameter arguments, choose names that match


class BookmarkFragment : Fragment() {

  private lateinit var binding: FragmentBookmarkBinding

  lateinit var rvAdapter: BookmarkRVAdapter
  val bookmarkIdList = mutableListOf<String>()
  val items = ArrayList<ContentModel>()
  val itemKeyList = ArrayList<String>()

  private val TAG = BookmarkFragment::class.java.simpleName
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)


    //2
    getBookmarkData()
    //3
    rvAdapter = BookmarkRVAdapter(requireContext(), items, itemKeyList, bookmarkIdList)


    val rv: RecyclerView = binding.bookmarkRV
    rv.adapter = rvAdapter
    rv.layoutManager = GridLayoutManager(requireContext(), 2)


    rvAdapter.setOnItemClickListener(object : BookmarkRVAdapter.OnItemClickListener{
      override fun onItemClick(v: View, data: ContentModel, pos : Int) {
        Log.d("click", "FragmentRVAdpater click")




        val ft = fragmentManager!!.beginTransaction()
        ft.detach(this@BookmarkFragment).attach(this@BookmarkFragment).commit()


        rvAdapter.notifyDataSetChanged()

      }

    })




    binding.hometap.setOnClickListener {
      it.findNavController().navigate(R.id.action_bookmarkFragment_to_homeFragment)
    }

    binding.tiptap.setOnClickListener {
      it.findNavController().navigate(R.id.action_bookmarkFragment_to_tipFragment)
    }

    binding.storetap.setOnClickListener {
      it.findNavController().navigate(R.id.action_bookmarkFragment_to_myinfo)
    }

    binding.talktap.setOnClickListener {
      it.findNavController().navigate(R.id.action_bookmarkFragment_to_talkFragment)
    }





    return binding.root


  }



  private fun getCategoryData() {
    val postListener = object : ValueEventListener {
      override fun onDataChange(dataSnapshot: DataSnapshot) {


        for (dataModel in dataSnapshot.children) {

          Log.d(TAG, dataModel.toString())
          val item = dataModel.getValue(ContentModel::class.java)
          if (bookmarkIdList.contains(dataModel.key.toString())) {
            items.add(item!!)
            itemKeyList.add(dataModel.key.toString())
          }

        }
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


  private fun getBookmarkData() {

    val postListener = object : ValueEventListener {
      override fun onDataChange(dataSnapshot: DataSnapshot) {
        bookmarkIdList.clear()
        items.clear()
        for (dataModel in dataSnapshot.children) {
          bookmarkIdList.add(dataModel.key.toString())
        }
//1




        rvAdapter.notifyDataSetChanged()

        getCategoryData()
      }

      override fun onCancelled(databaseError: DatabaseError) {
        // Getting Post failed, log a message
        Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
      }
    }
    FBRef.bookmarkRef.child(FBauth.getUid()).addValueEventListener(postListener)

  }

}
