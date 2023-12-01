package com.infinite.massiveprojectmobilezwh.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R

class ProfilBantuanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_bantuan)
        val btnBack = findViewById<ImageView>(R.id.kembali)
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}