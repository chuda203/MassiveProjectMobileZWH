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
        val btn_back = findViewById<ImageView>(R.id.back)
        btn_back.setOnClickListener {
            // Replace or add BerandaListFragment
            val berandaListFragment = BerandaListFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, berandaListFragment)
                .addToBackStack(null)
                .commitNow() // guna commit untuk transasi
        }

        val btn_tukar = findViewById<LinearLayout>(R.id.linearlayout_tukar)
        btn_tukar.setOnClickListener {
            // Start BerandaTukarActivity
            Intent(this, BerandaTukarActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
