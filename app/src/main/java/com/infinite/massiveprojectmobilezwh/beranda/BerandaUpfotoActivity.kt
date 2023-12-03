package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R

class BerandaUpfotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_upfoto)
        // Intent ke Konfirmasi Order
        val btnConfrim = findViewById<Button>(R.id.bt_confirmation)
        btnConfrim.setOnClickListener {
            Intent(this, BerandaOrderActivity::class.java).also {
                startActivity(it)
            }
        }
        // kembali ke Activity sebelumnya
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        btnBack.setOnClickListener {
            // Akhiri Activity, alternatif onBackPressed
            finish()
        }
    }
}