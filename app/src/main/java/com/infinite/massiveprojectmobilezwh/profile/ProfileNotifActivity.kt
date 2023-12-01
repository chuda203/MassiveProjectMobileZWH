package com.infinite.massiveprojectmobilezwh.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.profil.ProfilListFragment
import com.infinite.massiveprojectmobilezwh.ui.DaftarActivity

class ProfileNotifActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_notif)

        // Pengaturan OnClickListener untuk teks "back ke profile Customer"
        val bt_back = findViewById<ImageView>(R.id.back1)
        bt_back.setOnClickListener {
            onBackPressed()
            }
        }
    }
