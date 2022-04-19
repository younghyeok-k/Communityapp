package com.example.communityapp.contentlist

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.communityapp.R
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth

class ContentRVAdapter(val context: Context,
                       val items: ArrayList<ContentModel>,
                       val keyList:ArrayList<String>,
                       val bookmarkIdList:MutableList<String>) :
    RecyclerView.Adapter<ContentRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.ViewHolder, position: Int) {


        holder.bindItem(items[position],keyList[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: ContentModel,key:String) {

            itemView.setOnClickListener {
                Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ContentshowActivity::class.java)
                intent.putExtra("url", item.webUrl)
                itemView.context.startActivity(intent)

            }

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea=itemView.findViewById<ImageView>(R.id.bookmarkArea)
//

            if(bookmarkIdList.contains(key)){
                bookmarkArea.setImageResource(R.drawable.bookmark_color)
            }else{
                bookmarkArea.setImageResource(R.drawable.bookmark_white)
            }

            bookmarkArea.setOnClickListener{
                Toast.makeText(context, key, Toast.LENGTH_SHORT)
                  Log.d("ContentRVAdapter",FBauth.getUid())


                // 북마크가 있을때 삭제
                if(bookmarkIdList.contains(key)){


                    FBRef.bookmarkRef
                        .child(FBauth.getUid())
                        .child(key)
                        .removeValue()


                }else{// 북마크가 없을때
                    FBRef.bookmarkRef
                        .child(FBauth.getUid())
                        .child(key)
                        .setValue(BookmarkModel(true))

                }
            }

            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)
        }
    }

}