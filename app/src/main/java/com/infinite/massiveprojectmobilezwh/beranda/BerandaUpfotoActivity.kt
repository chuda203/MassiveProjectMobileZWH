package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.infinite.massiveprojectmobilezwh.R

class BerandaUpfotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_upfoto)
        val btn_confrim = findViewById<Button>(R.id.bt_confirmation)
        btn_confrim.setOnClickListener {
            Intent(this, BerandaOrderActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}