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
        // berhasil masuk, masuk ke beranda pengguna
        val btnMasuk = findViewById<Button>(R.id.bt_confirmation)
        btnMasuk.setOnClickListener {
            Intent(this, BerandaListActivity::class.java).also {
                startActivity(it)
            }
        }

        // Pengaturan OnClickListener untuk teks "Daftar"
        val btnRegis = findViewById<TextView>(R.id.tv_to_register)
        btnRegis.setOnClickListener {
            Intent(this, DaftarActivity::class.java).also {
                startActivity(it)
            }
        }

        // Mengaktifkan fungsi hide dan unhide password
        val editTextPassword = findViewById<EditText>(R.id.et_password)
        val imageViewToggle = findViewById<ImageView>(R.id.ic_password)
        imageViewToggle.setOnClickListener {
            // Saat ImageView diklik, ubah tipe input teks
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility(editTextPassword, isPasswordVisible)
        }

    }

    // Function untuk fitur hide/unhide password
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