package com.infinite.massiveprojectmobilezwh.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.profile.ProfileListFragment

class ChatConversationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_conversation)

        // Pengaturan OnClickListener untuk teks "back ke chat"
        val bt_back2 = findViewById<ImageView>(R.id.back)
        bt_back2.setOnClickListener {
            Intent(this, ChatListFragment::class.java).also {
                startActivity(it)
            }
        }
    }
}