package com.example.communityapp.fragments

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.communityapp.R
import com.example.communityapp.board.BoardListVAdatper
import com.example.communityapp.board.BoardModel
import com.example.communityapp.board.BoardinsideActivity
import com.example.communityapp.board.BoardwriteActivity
import com.example.communityapp.contentlist.BookmarkRVAdapter
import com.example.communityapp.contentlist.ContentModel
import com.example.communityapp.databinding.FragmentTalkBinding
import com.example.communityapp.utills.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class TalkFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentTalkBinding
    private val TAG = TalkFragment::class.java.simpleName

    private val boarddataList = mutableListOf<BoardModel>()
    private val boardkeyList = mutableListOf<String>()

    private lateinit var boardRVAdapter: BoardListVAdatper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk, container, false)



        boardRVAdapter = BoardListVAdatper(boarddataList)
        binding.boardListView.adapter = boardRVAdapter


        binding.boardListView.setOnItemClickListener { parent, view, position, id ->
            //첫번째 방법
//            val intent = Intent(context, BoardinsideActivity::class.java)
//            intent.putExtra("title",boarddataList[position].title)
//            intent.putExtra("content",boarddataList[position].content)
//            intent.putExtra("time",boarddataList[position].time)
//            startActivity(intent)


            //두번쨰 방법
            val intent = Intent(context, BoardinsideActivity::class.java)
            intent.putExtra("key",boardkeyList[position])

            startActivity(intent)


        }

        binding.writebtn.setOnClickListener {
            val intent = Intent(context, BoardwriteActivity::class.java)
            startActivity(intent)

        }

        binding.hometap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }

        binding.bookmarktap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
        }

        binding.info.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_myinfo)
        }

        binding.tiptap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }

        getFBBoardData()
        return binding.root
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


}