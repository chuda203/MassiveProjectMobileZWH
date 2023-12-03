package com.infinite.massiveprojectmobilezwh.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R

class ProfileHelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_help)
        // kembali ke activity sebelumnya
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        btnBack.setOnClickListener {
            finish()
        }
    }
}