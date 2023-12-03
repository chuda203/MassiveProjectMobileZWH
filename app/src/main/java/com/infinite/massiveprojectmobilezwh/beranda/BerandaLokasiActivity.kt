package com.infinite.massiveprojectmobilezwh.beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.infinite.massiveprojectmobilezwh.R

class BerandaLokasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_lokasi)
        // kembali ke Activity sebelumnya
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        btnBack.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
        }
    }
}