package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.infinite.massiveprojectmobilezwh.R

class BerandaCameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_camera)

        // OnClick shutter
        val btnShutter = findViewById<ImageView>(R.id.iv_shutter)
        btnShutter.setOnClickListener {
            Intent(this, BerandaUpfotoActivity::class.java).apply {
                startActivity(this)
            }
        }

        // OnClick close button
        val ivClose = findViewById<ImageView>(R.id.iv_close)
        ivClose.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
            }
        }
    }

