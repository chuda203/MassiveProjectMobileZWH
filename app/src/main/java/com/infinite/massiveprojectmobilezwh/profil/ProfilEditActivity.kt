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
        replaceFragment(ProfilEditFragment())

//        val btnEdit : ImageView = findViewById(R.id.iv_edit_avatar)
//        btnEdit.setOnClickListener {
//            val intent = Intent(this, ProfilCameraActivity::class.java)
//            startActivity(intent)
//        }


    }
    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}