package com.infinite.massiveprojectmobilezwh.profil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.profile.ProfileListFragment

class ProfilNotifActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_notif)
        // Pengaturan OnClickListener untuk teks "back ke profile Customer"
        val bt_back = findViewById<ImageView>(R.id.back1)
        bt_back.setOnClickListener {
            Intent(this, ProfilListFragment::class.java).also {
                startActivity(it)
            }
        }
    }
}