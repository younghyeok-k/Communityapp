package com.example.communityapp.board

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.communityapp.R
import com.example.communityapp.utills.FBauth

class BoardListVAdatper(val boardList:MutableList<BoardModel>):BaseAdapter() {
    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView=convertView
//        if(convertView==null){
        convertView=LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item,parent,false)

//        }

        val itemLinearlayoutView =convertView?.findViewById<LinearLayout>(R.id.itemview)
        val title=convertView?.findViewById<TextView>(R.id.titleArea)
        val context=convertView?.findViewById<TextView>(R.id.contentArea)
        val time =convertView?.findViewById<TextView>(R.id.timeArea)


        if(boardList[position].uid.equals(FBauth.getUid())){
            itemLinearlayoutView?.setBackgroundColor(Color.parseColor("#000033"))
            title?.setTextColor(Color.parseColor("#ffffff"))
            context?.setTextColor(Color.parseColor("#ffffff"))
            time?.setTextColor(Color.parseColor("#ffffff"))

        }
        title!!.text=boardList[position].title
        context!!.text=boardList[position].content
        time!!.text=boardList[position].time


        return convertView!!
    }
}