package com.example.communityapp.contentlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.communityapp.R
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ContentListActivity : AppCompatActivity() {

    lateinit var myRef: DatabaseReference
    val bookmarkIdlist = mutableListOf<String>()
   lateinit var  rvAdapter:ContentRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contnet_list)
        val texttitle=findViewById<TextView>(R.id.cltextview)
        val database = Firebase.database
        val backpress=findViewById<ImageView>(R.id.backpress)
        val items = ArrayList<ContentModel>()
        val itemKeyList = ArrayList<String>()

         rvAdapter = ContentRVAdapter(baseContext, items, itemKeyList,bookmarkIdlist)

        val category = intent.getStringExtra("category")
        backpress.setOnClickListener{
            super.onBackPressed()
        }


        if (category == "category1") {
            myRef = database.getReference("contents")
            texttitle.setText("전체항목")


        } else if (category == "category2") {
            myRef = database.getReference("contents2")
            texttitle.setText("노트북")

        } else if (category == "category3") {
            myRef = database.getReference("contents3")
            texttitle.setText("컴퓨터")

        } else if (category == "category4") {
            myRef = database.getReference("contents4")
            texttitle.setText("테블릿")

        } else if (category == "category5") {
            myRef = database.getReference("contents5")
            texttitle.setText("휴대폰")

        } else if (category == "category6") {
            myRef = database.getReference("contents6")
            texttitle.setText("경제")

        } else if (category == "category7") {
            myRef = database.getReference("contents7")
            texttitle.setText("여가 활동")

        } else if (category == "category8") {
            myRef = database.getReference("contents8")
            texttitle.setText("기타")

        }
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {
                    val item = dataModel.getValue(ContentModel::class.java)
                    items.add(item!!)
                    itemKeyList.add(dataModel.key.toString())

                }
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)


        val rv: RecyclerView = findViewById(R.id.rv)




        rv.adapter = rvAdapter
//        rv.layoutManager=LinearLayoutManager(this)
        rv.layoutManager = GridLayoutManager(this, 2)

        getBookmarkData()


    }

    private fun getBookmarkData() {

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                bookmarkIdlist.clear()
                for (dataModel in dataSnapshot.children) {
                    bookmarkIdlist.add(dataModel.key.toString())

                }
                Log.d("Bookmark:", bookmarkIdlist.toString())
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.bookmarkRef.child(FBauth.getUid()).addValueEventListener(postListener)
    }


}



