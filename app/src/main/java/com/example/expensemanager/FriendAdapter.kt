package com.example.expensemanager

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class FriendAdapter(
    private val activity: Activity,
    private val context: Context,
    private val listOfFriends: ArrayList<Friend>
) :
    BaseAdapter() {
    override fun getCount(): Int {
        return listOfFriends.size
    }

    override fun getItem(p0: Int): Friend {
        return listOfFriends[p0]
    }

    override fun getItemId(p0: Int): Long {
        return listOfFriends[p0].roll_no.hashCode().toLong()
    }

    override fun getView(p0: Int, convertView: View?, p2: ViewGroup?): View {
        val friendView: View
        val friendHolder: ViewHolder

        if (convertView == null) {

            friendView = LayoutInflater.from(p2?.context).inflate(R.layout.friend_view, p2, false)
            friendHolder = ViewHolder()

            with(friendHolder) {

                avatar = friendView.findViewById(R.id.dp)
                nameBox = friendView.findViewById(R.id.name)
                nicknameBox = friendView.findViewById(R.id.nickname)
                username = friendView.findViewById(R.id.codechef)

                friendView.tag = this
            }
        } else {
            friendView = convertView
            friendHolder = convertView.tag as ViewHolder
        }

        with(friendHolder) {

            val target: String = if (getItem(p0).comdchemf == "NA")
                "https://www.codechef.com/login?destination=/"
            else
                ("https://www.codechef.com/users/" + getItem(p0).comdchemf)

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(target))
            username.setOnClickListener {
                activity.startActivity(intent)
            }

            nameBox.text = listOfFriends[p0].name
            nicknameBox.text = getItem(p0).name
            username.text = getItem(p0).comdchemf
        }

        return friendView
    }

    private class ViewHolder {
        lateinit var avatar: ImageView
        lateinit var nameBox: TextView
        lateinit var nicknameBox: TextView
        lateinit var username: TextView
    }


}