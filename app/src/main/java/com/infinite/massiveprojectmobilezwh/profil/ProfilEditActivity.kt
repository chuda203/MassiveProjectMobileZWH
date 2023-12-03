package com.infinite.massiveprojectmobilezwh.profil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.infinite.massiveprojectmobilezwh.R

class ProfilEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_edit)

        // Intent ke camera untuk capture photo profil
        val btnEdit : ImageView = findViewById(R.id.iv_edit_avatar)
        btnEdit.setOnClickListener {
            val intent = Intent(this, ProfilCameraActivity::class.java)
            startActivity(intent)
        }
        // kembali ke activity sebelumnya
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        btnBack.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
        }

    }

}