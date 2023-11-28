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
        val btn_shutter = findViewById<ImageView>(R.id.iv_shutter)
        btn_shutter.setOnClickListener {
            Intent(this, ProfilEditActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}