package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.infinite.massiveprojectmobilezwh.R

class BerandaOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_order)

        replaceFragment(BerandaOrderFragment())

        val btn_confrim = findViewById<Button>(R.id.bt_confirmation)
        btn_confrim.setOnClickListener {
            Intent(this, BerandaCariActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.iv_capture_preview, fragment)
        transaction.commit()
    }
}