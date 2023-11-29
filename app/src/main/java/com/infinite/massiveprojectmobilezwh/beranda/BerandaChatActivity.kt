package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.chat.ChatConversationActivity

class BerandaChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_chat)
        val btn_confrim : CardView = findViewById(R.id.cardView_region1)

        btn_confrim.setOnClickListener {
            val intent = Intent(this, BerandaObrolanActivity::class.java)
            startActivity(intent)
        }

    }
}