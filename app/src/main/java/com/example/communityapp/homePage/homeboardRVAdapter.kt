package com.example.communityapp.homePage

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.communityapp.R
import com.example.communityapp.board.BoardModel
import com.example.communityapp.utills.FBauth

class homeboardRVAdapter (val boardList:MutableList<BoardModel>): BaseAdapter() {
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

        convertView= LayoutInflater.from(parent?.context).inflate(R.layout.home_board,parent,false)


        val itemConstraintlayout =convertView?.findViewById<ConstraintLayout>(R.id.itemview)
        val title=convertView?.findViewById<TextView>(R.id.titleArea)

        val time =convertView?.findViewById<TextView>(R.id.timeArea)



        title!!.text=boardList[position].title
        time!!.text=boardList[position].time


        return convertView!!
    }
}