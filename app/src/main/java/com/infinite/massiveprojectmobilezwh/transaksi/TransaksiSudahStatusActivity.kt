package com.infinite.massiveprojectmobilezwh.transaksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R

class TransaksiSudahStatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi_sudah_status)
        val btnBack = findViewById<ImageView>(R.id.back)
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}