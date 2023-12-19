package com.infinite.massiveprojectmobilezwh.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R

class ProfileNotifActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_notif)

        // Pengaturan OnClickListener untuk teks "back ke profile Customer"
        val bt_back = findViewById<ImageView>(R.id.iv_back)
        bt_back.setOnClickListener {

            finish()
            }
        }
    }
