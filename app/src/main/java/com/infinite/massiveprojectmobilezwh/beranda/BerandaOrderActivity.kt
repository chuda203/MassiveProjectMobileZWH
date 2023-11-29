package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
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

        val items = listOf("Material", "Design", "Components", "Android")
        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)
        val adapter = ArrayAdapter(this, R.layout.list_item, items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->

        }


    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.iv_capture_preview, fragment)
        transaction.commit()
    }
}