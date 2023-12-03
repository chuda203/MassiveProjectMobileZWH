package com.infinite.massiveprojectmobilezwh.beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import com.infinite.massiveprojectmobilezwh.R

class BerandaCariActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_cari)

        // ganti fragment setelah 1,5 detik
        Handler(Looper.getMainLooper()).postDelayed({
            replaceFragment(BerandaProsesFragment())
        },1500)

    }

    // function ganti fragment
    private fun replaceFragment(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}