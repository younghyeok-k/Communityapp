package com.example.communityapp.board

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.communityapp.R
import com.example.communityapp.comment.CommentLVAdapter
import com.example.communityapp.comment.CommentModel
import com.example.communityapp.databinding.ActivityBoardinsideBinding
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class BoardinsideActivity : AppCompatActivity() {

    private val TAG = BoardinsideActivity::class.java.simpleName

    private lateinit var binding: ActivityBoardinsideBinding

    private lateinit var commentAdapter: CommentLVAdapter
    private var commentDataList = mutableListOf<CommentModel>()

    private lateinit var key: String

    private val commentkeylist = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardinside)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_boardinside)


        binding.boardsettingicon.setOnClickListener {


            showDialog()

        }
        binding.backpress.setOnClickListener {
            super.onBackPressed()
        }

        key = intent.getStringExtra("key").toString()

        getBoarddata(key)
        getImageData(key)




        binding.commentbtn.setOnClickListener {

            insertComment(key)
            binding.commentArea.text.clear()

        }

        commentAdapter = CommentLVAdapter(commentDataList)
        binding.commentRv.adapter = commentAdapter


        commentAdapter.setItemClickListener(object: CommentLVAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {

                FBRef.commnetRef.child(key).child(commentkeylist[position]).removeValue()
                Toast.makeText(this@BoardinsideActivity,"댓글 삭제 완료", Toast.LENGTH_SHORT).show()

            }
        })
        getCommentData(key)


    }

    fun getCommentData(key: String) {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                commentDataList.clear()
                commentkeylist.clear()
                for (dataModel in dataSnapshot.children) {
                    val item = dataModel.getValue(CommentModel::class.java)
                    commentDataList.add(item!!)
                    commentkeylist.add(dataModel.key.toString())
                }
                commentDataList.reverse()
                commentkeylist.reverse()
                commentAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }

        FBRef.commnetRef.child(key).addValueEventListener(postListener)

    }


    fun insertComment(key: String) {
        val email:String

        if (FBauth.getemail().equals("null")||FBauth.getemail().isEmpty()){
            email="익명"
        }else {
            email = FBauth.getemail()
        }

        FBRef
            .commnetRef
            .child(key)
            .push()
            .setValue(
                CommentModel(
                    binding.commentArea.text.toString(),
                    FBauth.getTime(),
                    FBauth.getUid(),
                    email

                )
            )
        Toast.makeText(this, "댓글 입력 완료", Toast.LENGTH_SHORT).show()

    }


    private fun showDialog() {

        val mDialogView = layoutInflater.inflate(R.layout.custom_dialog, null)

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("게시글 수정/삭제")


        val alertDialog = mBuilder.show()

        alertDialog.findViewById<Button>(R.id.editbtn)?.setOnClickListener {
            //수정

            val intent = Intent(this, BoardEditActivity::class.java)
            intent.putExtra("key", key)
            startActivity(intent)
            finish()
        }
        alertDialog.findViewById<Button>(R.id.deletebtn)?.setOnClickListener {

            //삭제

            FBRef.boardRef.child(key).removeValue()
            Toast.makeText(this, "삭제 완료", Toast.LENGTH_SHORT).show()
            finish()

        }

    }


    private fun getImageData(key: String) {
        val storageReference = Firebase.storage.reference.child("boardimage/"+key + ".png")

        // ImageView in your Activity
        val imageViewFB = binding.getimageArea

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->

            if (task.isSuccessful) {
                Glide.with(this)
                    .load(task.result)
                    .into(imageViewFB)
            } else {
                binding.getimageArea.isVisible = false
            }
        })
    }

    private fun getBoarddata(key: String) {

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                try {

                    Log.d(TAG, dataSnapshot.toString())
                    val datamodel = dataSnapshot.getValue(BoardModel::class.java)

                    binding.titleArea.text = datamodel!!.title
                    binding.contentArea.text = datamodel!!.content
                    binding.timeArea.text = datamodel!!.time
                    binding.userEmail.text=datamodel!!.email
                    val myUid = FBauth.getUid()
                    val writerUid = datamodel.uid
                    if (myUid.equals(writerUid)) {
                        binding.boardsettingicon.isVisible = true
                    } else {

                    }
                } catch (e: Exception) {
                    Log.d(TAG, "삭제완료")
                }


            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }

        FBRef.boardRef.child(key).addValueEventListener(postListener)

    }


}