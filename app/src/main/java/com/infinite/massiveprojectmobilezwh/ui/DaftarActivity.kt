package com.infinite.massiveprojectmobilezwh.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        // Pengaturan OnClickListener untuk tombol "Daftar"
        val btnDaftar = findViewById<Button>(R.id.bt_confirmation)
        btnDaftar.setOnClickListener {
            Intent(this, MasukActivity::class.java).also {
                startActivity(it)
            }
        }

        // Pengaturan OnClickListener untuk teks "Masuk"
        val tvLogin = findViewById<TextView>(R.id.tv_login)
        tvLogin.setOnClickListener {
            Intent(this, MasukActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
