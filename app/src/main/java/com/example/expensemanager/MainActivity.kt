package com.example.expensemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val friends = arrayListOf<Friend>(
            Friend("Amtishay", "Bochliwala", "03414802720".toLong(), 2122),
            Friend("Cheemrag", "ChiDiya", "04214802720".toLong(), 200),
            Friend("Gaurav", "Gaumrav", "05014802720".toLong(), 21),
            Friend("Kumnal", "Chushwaha", "07714802720".toLong(), -1500),
        )

        val adapter = FriendAdapter(this, friends)

        val friendsList: ListView = findViewById(R.id.comders)
        friendsList.adapter = adapter
    }
}