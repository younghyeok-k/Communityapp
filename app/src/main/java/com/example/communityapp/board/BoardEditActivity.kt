package com.example.communityapp.board

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.communityapp.R
import com.example.communityapp.databinding.ActivityBoardEditBinding
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream

class BoardEditActivity : AppCompatActivity() {

    private lateinit var key: String
    private lateinit var binding: ActivityBoardEditBinding
    private var isimageUpload = false
    private var TAG = BoardEditActivity::class.java.simpleName

    private lateinit var writerUid: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_edit)

        key = intent.getStringExtra("key").toString()


        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_edit)
        getBoarddata(key)
        getImageData(key)

        binding.editBtn.setOnClickListener {
            editBoardata(key)
            finish()
            if (isimageUpload == true) {
                imageupload(key)
            }
        }

        binding.imageArea.setOnClickListener {

            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)

            startActivityForResult(gallery, 100)
            isimageUpload = true
        }

    }

    private fun editBoardata(key: String) {
        FBRef.boardRef
            .child(key)
            .setValue(
                BoardModel(
                    binding.titleArea.text.toString(),
                    binding.contentArea.text.toString(),
                    writerUid,
                    FBauth.getTime()
                )


            )


    }

    private fun getBoarddata(key: String) {

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val dataModel = dataSnapshot.getValue(BoardModel::class.java)



                binding.titleArea.setText(dataModel?.title)
                binding.contentArea.setText(dataModel?.content)

                writerUid = dataModel!!.uid

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }

        FBRef.boardRef.child(key).addValueEventListener(postListener)

    }

    private fun getImageData(key: String) {
        val storageReference = Firebase.storage.reference.child("boardimage/"+key + ".png")

        // ImageView in your Activity
        val imageViewFB = binding.imageArea

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->

            if (task.isSuccessful) {
                Glide.with(this)
                    .load(task.result)
                    .into(imageViewFB)
            } else {

            }
        })
    }
    private fun imageupload(key: String) {

        val storage = Firebase.storage
        val storageRef = storage.reference
        val mountainsRef = storageRef.child("boardimage/"+key + ".png")


        val imageView = binding.imageArea
        imageView.isDrawingCacheEnabled = true
        imageView.buildDrawingCache()
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = mountainsRef.putBytes(data)
        uploadTask.addOnFailureListener {
            Toast.makeText(this, "업로드실패", Toast.LENGTH_SHORT)
        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 100) {
            binding.imageArea.setImageURI(data?.data)

        }
    }




}