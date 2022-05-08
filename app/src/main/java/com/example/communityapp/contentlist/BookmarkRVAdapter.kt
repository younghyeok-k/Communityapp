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
import com.example.communityapp.databinding.FragmentBookmarkBinding
import com.example.communityapp.fragments.BookmarkFragment
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth

class BookmarkRVAdapter(val context: Context,
val items: ArrayList<ContentModel>,
val keyList:ArrayList<String>,
val bookmarkIdList:MutableList<String>) : RecyclerView.Adapter<BookmarkRVAdapter.ViewHolder>() {

    var datas = mutableListOf<BookmarkFragment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: BookmarkRVAdapter.ViewHolder, position: Int) {


        holder.bindItem(items[position],keyList[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }



    //  Click 이벤트 적용하기
    interface OnItemClickListener{
        fun onItemClick(v:View, data: ContentModel, pos: Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
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


                bookmarkArea.setImageResource(R.drawable.bookmark_color)

//test

            bookmarkArea.setOnClickListener{
                Toast.makeText(context, key, Toast.LENGTH_SHORT)
                Log.d("BookmarkRVAdapter", FBauth.getUid())
                Log.d("Bookmarkrv:", bookmarkIdList.toString())

                    FBRef.bookmarkRef
                        .child(FBauth.getUid())
                        .child(key)
                        .removeValue()

                val pos = adapterPosition
                if(pos!= RecyclerView.NO_POSITION)
                {

                        listener?.onItemClick(itemView,item,pos)

                }
//

                notifyDataSetChanged()


            }



            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)
        }
    }


}