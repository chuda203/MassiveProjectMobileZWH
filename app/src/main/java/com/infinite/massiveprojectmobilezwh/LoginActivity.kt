package com.infinite.massiveprojectmobilezwh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
    }
}