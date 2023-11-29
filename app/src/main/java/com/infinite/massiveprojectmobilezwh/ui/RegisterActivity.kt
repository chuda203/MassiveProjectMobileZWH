package com.infinite.massiveprojectmobilezwh.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val btn_daftar = findViewById<Button>(R.id.bt_confirmation)
        btn_daftar.setOnClickListener {
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
        val tvLogin = findViewById<TextView>(R.id.tv_login)
        tvLogin.setOnClickListener {
            Intent(this, MasukActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}