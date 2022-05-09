package com.example.communityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.communityapp.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        auth = Firebase.auth


        if(auth.currentUser?.uid==null){
            Log.d("splashActivity","null")
            Handler().postDelayed({
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            },3000)
        }else{
            Log.d("splashActivity","notnull")
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },3000)

        }

//        Handler().postDelayed({
//            startActivity(Intent(this,introActivity::class.java))
//            finish()
//        },3000)
    }
}