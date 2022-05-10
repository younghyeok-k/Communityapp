package com.example.communityapp.fragments

import android.R.attr
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.communityapp.MainActivity
import com.example.communityapp.R
import com.example.communityapp.auth.PasswordChangeActivity
import com.example.communityapp.board.BoardEditActivity
import com.example.communityapp.databinding.FragmentMyinfoBinding
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import android.R.attr.data
import android.net.Uri


class MyInfoFragment : Fragment() {
    private lateinit var binding: FragmentMyinfoBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var key: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        auth = FirebaseAuth.getInstance();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_myinfo, container, false)


//        binding.passwdchange.setOnClickListener {
//            showDialog()
//
//        }
        if (FBauth.getemail().isEmpty()||FBauth.getemail().equals("null")) {
            binding.userEmail.setText("익명사용자")
        } else {
            binding.userEmail.setText(FBauth.getemail())

        }


        key = FBauth.getemail().toString()

        getImageData(key)


        binding.profileImg.setOnClickListener {

            if(!FBauth.getemail().isEmpty()||!FBauth.getemail().equals("null")) {
                val gallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                startActivityForResult(gallery, 100)
            }else{
                Toast.makeText(context,"익명사용자입니다",Toast.LENGTH_SHORT)
            }

        }

        binding.hometap.setOnClickListener {
            it.findNavController().navigate(R.id.action_myinfo_to_homeFragment)
        }

        binding.bookmarktap.setOnClickListener {
            it.findNavController().navigate(R.id.action_myinfo_to_bookmarkFragment)
        }

        binding.tiptap.setOnClickListener {
            it.findNavController().navigate(R.id.action_myinfo_to_tipFragment)
        }

        binding.talktap.setOnClickListener {
            it.findNavController().navigate(R.id.action_myinfo_to_talkFragment)
        }


        return binding.root
    }

    private fun showDialog() {

        val mDialogView = layoutInflater.inflate(R.layout.reauth_dialog, null)

        val mBuilder = AlertDialog.Builder(requireContext())
            .setView(mDialogView)
            .setTitle("비밀번호인증")


        val alertDialog = mBuilder.show()

        alertDialog.findViewById<Button>(R.id.checkbtn)?.setOnClickListener {
            //수정

            val intent = Intent(context, PasswordChangeActivity::class.java)
            startActivity(intent)
            alertDialog.dismiss()
        }


    }

    private fun imageupload(key: String) {


        val storage = Firebase.storage
        val storageRef = storage.reference
        val mountainsRef = storageRef.child("userimage/" + key + ".png")


        val imageView = binding.profileImg
        imageView.isDrawingCacheEnabled = true
        imageView.buildDrawingCache()
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = mountainsRef.putBytes(data)
        uploadTask.addOnFailureListener {
            Toast.makeText(context, "업로드실패", Toast.LENGTH_SHORT)

        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
        }
    }

    private fun getImageData(key: String) {
        val storageReference = Firebase.storage.reference.child("userimage/" + key + ".png")

        // ImageView in your Activity
        val imageViewFB = binding.profileImg

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->

            if (task.isSuccessful) {
                Glide.with(this)
                    .load(task.result)
                    .into(imageViewFB)
            }
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == 100) {

            binding.profileImg.setImageURI(data?.data)
            imageupload(key)
        }
    }


}