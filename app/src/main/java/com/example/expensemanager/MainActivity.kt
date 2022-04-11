package com.example.expensemanager

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val register: String = "https://www.codechef.com/login?destination=/"
        val user: String = "https://www.codechef.com/users/"
        val friends = arrayListOf<Friend>(
            Friend("Amtishay", "Bochliwala", "03414802720".toLong(), "heavycoder5203"),
            Friend("Cheemrag", "ChiDiya", "04214802720".toLong(), "hunter177"),
            Friend("Gaurav", "Gaumrav", "05014802720".toLong(), "gaurav4720"),
            Friend("Kumnal", "Chushwaha", "07714802720".toLong(), "NA"),
        )

        val view: View = findViewById(R.id.codechef)
        view.tag

        val adapter = FriendAdapter(this, this.applicationContext, friends)

        val friendsList: ListView = findViewById(R.id.comders)
        friendsList.adapter = adapter
    }
}