package com.example.communityapp.homePage

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
import com.example.communityapp.contentlist.ContentModel
import com.example.communityapp.contentlist.ContentshowActivity
import com.example.communityapp.databinding.FragmentBookmarkBinding
import com.example.communityapp.fragments.BookmarkFragment
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth

class HomeContentRVAdapter(
    val context: Context,
    val items: ArrayList<ContentModel>,
    val keyList: ArrayList<String>,
) : RecyclerView.Adapter<HomeContentRVAdapter.ViewHolder>() {
    var datas = mutableListOf<BookmarkFragment>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeContentRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_rv_item, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: HomeContentRVAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position], keyList[position])
    }
    override fun getItemCount(): Int {
        return items.size
    }
    //  Click 이벤트 적용하기
    interface OnItemClickListener {
        fun onItemClick(v: View, data: ContentModel, pos: Int)
    }

    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: ContentModel, key: String) {

            itemView.setOnClickListener {
                Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ContentshowActivity::class.java)
                intent.putExtra("url", item.webUrl)
                itemView.context.startActivity(intent)

            }
            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)

            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)
        }
    }


}