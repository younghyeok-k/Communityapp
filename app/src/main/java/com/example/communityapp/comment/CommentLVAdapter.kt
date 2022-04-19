package com.example.communityapp.comment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
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



        title!!.text = commentlist[position].commentTitle
        time!!.text = commentlist[position].commnetCreatedTime


        return convertView!!

    }


}