package com.infinite.massiveprojectmobilezwh.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.beranda.BerandaListActivity

class MasukActivity : AppCompatActivity() {

    private var isPasswordVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)
        val bt_pengguna = findViewById<Button>(R.id.Button1)
        bt_pengguna.setOnClickListener {
            Intent(this, BerandaListActivity::class.java).also {
                startActivity(it)
            }
        }
        // Pengaturan OnClickListener untuk teks "Daftar"
        val bt_regis = findViewById<TextView>(R.id.textview9)
        bt_regis.setOnClickListener {
            Intent(this, DaftarActivity::class.java).also {
                startActivity(it)
            }
        }
        val editTextPassword = findViewById<EditText>(R.id.edt_username2)
        val imageViewToggle = findViewById<ImageView>(R.id.kunci1)

        imageViewToggle.setOnClickListener {
            // Saat ImageView diklik, ubah tipe input teks
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility(editTextPassword, isPasswordVisible)
        }

    }
    private fun togglePasswordVisibility(editText: EditText, isVisible: Boolean) {
        if (isVisible) {
            // Jika terlihat, ubah ke tipe teks biasa
            editText.transformationMethod = null
            editText.setSelection(editText.text.length) // Agar kursor tetap di akhir teks
        } else {
            // Jika tidak terlihat, ubah ke tipe password
            editText.transformationMethod = PasswordTransformationMethod()
            editText.setSelection(editText.text.length) // Agar kursor tetap di akhir teks
        }
    }
}