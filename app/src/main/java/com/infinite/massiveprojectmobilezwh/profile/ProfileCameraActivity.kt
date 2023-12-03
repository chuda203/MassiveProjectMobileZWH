package com.infinite.massiveprojectmobilezwh.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.profil.ProfilEditActivity

class ProfileCameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_camera)
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