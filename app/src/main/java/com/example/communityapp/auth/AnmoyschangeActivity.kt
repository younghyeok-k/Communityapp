package com.example.communityapp.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.communityapp.R
import com.example.communityapp.utills.FBauth
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class AnmoyschangeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

   private lateinit var mCurrentUser:FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anmoyschange)

        auth = FirebaseAuth.getInstance()

    }

    fun emailLogin(email: String?, password: String?) {
        val credential = EmailAuthProvider.getCredential(email!!, password!!)
        auth.getCurrentUser()?.linkWithCredential(credential)
            ?.addOnCompleteListener(this,
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {

                        mCurrentUser = task.result.user!!
                       // EmailAuthProvider.getCredential(mCurrentUser.getUid(), mCurrentUser.isAnonymous())
                    } else {

                        Toast.makeText(
                            this@AnmoyschangeActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
    }
}