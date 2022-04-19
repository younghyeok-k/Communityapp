package com.example.communityapp.contentlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import com.example.communityapp.R

class ContentshowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contentshow)


        val getUrl=intent.getStringExtra("url")


        val webView:WebView=findViewById(R.id.webView)
        webView.loadUrl(getUrl.toString())

    }
}