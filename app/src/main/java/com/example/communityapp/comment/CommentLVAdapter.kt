package com.example.communityapp.comment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.communityapp.R
import com.example.communityapp.utills.FBRef
import com.example.communityapp.utills.FBauth

class CommentLVAdapter(val commentlist: MutableList<CommentModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return commentlist.size
    }

    override fun getItem(position: Int): Any {
        return commentlist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView == null) {
            convertView =
                LayoutInflater.from(parent?.context)
                    .inflate(R.layout.commentlist_item, parent, false)

        }


        val title = convertView?.findViewById<TextView>(R.id.titleArea)

        val time = convertView?.findViewById<TextView>(R.id.timeArea)
        val email = convertView?.findViewById<TextView>(R.id.emailArea)


        title!!.text = commentlist[position].commentTitle
        time!!.text = commentlist[position].commnetCreatedTime
        email!!.text = commentlist[position].email
        val myUid = FBauth.getUid()
        val writerUid = commentlist[position].ukey
        val delete = convertView?.findViewById<ImageView>(R.id.comment_delete)
        if (myUid.equals(writerUid)) {
            delete?.isVisible = true
        } else {
            delete?.isVisible = false
        }
        delete?.setOnClickListener {
            itemClickListener.onClick(it, position)
        }

        return convertView!!

    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener: OnItemClickListener


}