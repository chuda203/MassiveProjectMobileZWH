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
        // kembali ke activity sebelumnya
        val btnShutter = findViewById<ImageView>(R.id.iv_shutter)
        btnShutter.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
        }
        // OnClick close button
        val ivClose = findViewById<ImageView>(R.id.iv_close)
        ivClose.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
        }
    }
}