package com.infinite.massiveprojectmobilezwh.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.beranda.BerandaListActivity

class MasukActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)
        val bt_pengguna = findViewById<Button>(R.id.Button1)
        bt_pengguna.setOnClickListener {
            Intent(this, BerandaListActivity::class.java).also {
                startActivity(it)
            }
        }
        // Pengaturan OnClickListener untuk teks "Daftar"
        val bt_regis = findViewById<TextView>(R.id.textview9)
        bt_regis.setOnClickListener {
            Intent(this, DaftarActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}