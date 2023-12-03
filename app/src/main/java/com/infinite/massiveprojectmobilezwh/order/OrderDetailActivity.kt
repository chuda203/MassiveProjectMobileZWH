package com.infinite.massiveprojectmobilezwh.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R

class OrderDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        // kembali ke activity sebelumnya
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        btnBack.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
        }
    }
}