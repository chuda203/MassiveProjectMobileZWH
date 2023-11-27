package com.infinite.massiveprojectmobilezwh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)
        val btn_daftar = findViewById<Button>(R.id.bt_confirmation)
        btn_daftar.setOnClickListener {
            Intent(this, MasukActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    }
