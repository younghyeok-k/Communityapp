package com.example.communityapp.board

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.communityapp.R
import com.example.communityapp.contentlist.BookmarkModel
import com.example.communityapp.databinding.ActivityBoardwriteBinding
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream

class BoardwriteActivity : AppCompatActivity() {


    private lateinit var binding: ActivityBoardwriteBinding
    private val TAG = BoardwriteActivity::class.java.simpleName
    private var isimageUpload = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardwrite)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_boardwrite)

        binding.writeBtn.setOnClickListener {
            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBauth.getUid()
            val time = FBauth.getTime()
            val email:String

            if (FBauth.getemail().equals("null")||FBauth.getemail().isEmpty()){
                 email="익명"
            }else {
               email = FBauth.getemail()
            }
            val key = FBRef.boardRef.push().key.toString()

//             파이어베이스 storage 에 이미지를 저장하고 싶습니다
//             만약에 내가 게시글을 클릭했을 때, 게시글에 대한 정보를 받아와야하는데
//             이미지 이름에 대한 정보를 모르기 때문에
//             이미지 이름을 문서의 key값을 해줘서 이미지에 대한 정보를 찾기쉽게 해야한다
//               val key=FBRef.boardRef.push().key.toString()
//             값으로 키값을 받아아와서 push() 에서 child(key) 값을 바꾸면된다

            Log.d(TAG, title)
            FBRef.boardRef
                .child(key)
                .setValue(BoardModel(title, content, uid, time,email))

            //이미지 클릭하면 어두운거 안나오게 (기본이미지 확인방법 다시)
            if (isimageUpload == true) {
                imageupload(key)
            }



            finish()
        }
        binding.imageArea.setOnClickListener {

            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)

            startActivityForResult(gallery, 100)
            isimageUpload = true
        }
        binding.backpress.setOnClickListener{
            super.onBackPressed()
        }



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