package com.infinite.massiveprojectmobilezwh.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.maps.MapsListActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val bt_masuk = findViewById<Button>(R.id.Button1)
        bt_masuk.setOnClickListener {
            Intent(this, MapsListActivity::class.java).also {
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