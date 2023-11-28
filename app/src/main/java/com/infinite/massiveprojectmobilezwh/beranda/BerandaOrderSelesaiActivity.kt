package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.dompet.BerandaDompetActivity

class BerandaOrderSelesaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_order_selesai)
        val btn_home = findViewById<Button>(R.id.bt_confirmation_home)
        val btn_history = findViewById<Button>(R.id.bt_confirmation_history)
        btn_home.setOnClickListener {
            Intent(this, BerandaListActivity::class.java).also {
                startActivity(it)
            }
        }
        btn_history.setOnClickListener {
            Intent(this, BerandaDompetActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}