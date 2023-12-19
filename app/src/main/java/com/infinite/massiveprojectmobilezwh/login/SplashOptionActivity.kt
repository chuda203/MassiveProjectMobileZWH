package com.infinite.massiveprojectmobilezwh.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.infinite.massiveprojectmobilezwh.R

class SplashOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_option)

        val btn_pelanggan = findViewById<Button>(R.id.myButton)
        val btn_pengepul = findViewById<Button>(R.id.myButton1)

        btn_pelanggan.setOnClickListener {
            Intent(this, DaftarActivity::class.java).also {
                startActivity(it)
            }
        }
        btn_pengepul.setOnClickListener {
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}