package com.infinite.massiveprojectmobilezwh.profil

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R

class ProfilCameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_camera)
        val btn_shutter = findViewById<ImageView>(R.id.iv_shutter)
        btn_shutter.setOnClickListener {
            Intent(this, ProfilEditActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}