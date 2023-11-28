package com.infinite.massiveprojectmobilezwh.dompet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.infinite.massiveprojectmobilezwh.R

class BerandaDompetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_dompet)
        val btn_tukar = findViewById<LinearLayout>(R.id.linearlayout_tukar)
        btn_tukar.setOnClickListener {
            Intent(this, BerandaTukarActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}