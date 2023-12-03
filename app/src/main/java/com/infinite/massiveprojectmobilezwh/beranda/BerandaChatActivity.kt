package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.chat.ChatConversationActivity

class BerandaChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_chat)
        // kembali ke Activity sebelumnya
        val btnBack : ImageView = findViewById(R.id.iv_back)
        btnBack.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
        }
    }
}