package com.example.communityapp.utills

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class FBauth {


    companion object{

        private  lateinit var  auth:FirebaseAuth

        fun getUid(): String{
            auth= FirebaseAuth.getInstance()
            return auth.currentUser?.uid.toString()

        }

        fun getTime():String{

            val currentDatatime=Calendar.getInstance().time
            val dataFormat=SimpleDateFormat("yyyy.MM.dd HH:mm:ss",Locale.KOREA).format(currentDatatime)

            return dataFormat
        }


    }

}