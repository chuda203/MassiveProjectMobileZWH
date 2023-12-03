package com.infinite.massiveprojectmobilezwh.dompet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.beranda.BerandaListFragment

class BerandaDompetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_dompet)

//nanti kalian testing dibagian ini pas saya testing kyk gimana mungkin di  hp saya atau dicodingannya
// -> pake finish() masalah selesai, tapi commitNow gak bisa jalan
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        btnBack.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
            //.commitNow() // guna commit untuk transasi
        }
    }
}
