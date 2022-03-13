package com.example.expensemanager

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class FriendAdapter(private val context: Context, private val listOfFriends: ArrayList<Friend>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return listOfFriends.size
    }

    override fun getItem(p0: Int): Friend {
        return listOfFriends[p0]
    }

    override fun getItemId(p0: Int): Long {
        return listOfFriends[p0].roll_no
    }

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        var container = view
        if (view == null)
            container = LayoutInflater.from(context).inflate(R.layout.friend_view, parent, false)

        val curr = listOfFriends[pos]
        Log.d("Hemlo", curr.roll_no.toString())
        val imageView = container!!.findViewById<ImageView>(R.id.imageView)
        val name = container.findViewById<TextView>(R.id.name)
        val nickName = container.findViewById<TextView>(R.id.nickname)
        val codechef = container.findViewById<TextView>(R.id.codechef)

        imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.my_avatar))
        name.text = curr.name
        nickName.text = curr.nick_name
        codechef.text = curr.comdchemf.toString()

        return container
    }

}