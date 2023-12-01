package com.infinite.massiveprojectmobilezwh.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R

class RegisterActivity : AppCompatActivity() {
    private var isPasswordVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val btn_daftar = findViewById<Button>(R.id.bt_confirmation)
        btn_daftar.setOnClickListener {
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
        val tvLogin = findViewById<TextView>(R.id.tv_login)
        tvLogin.setOnClickListener {
            Intent(this, MasukActivity::class.java).also {
                startActivity(it)
            }
        }
        val tvAgreement = findViewById<TextView>(R.id.tv_agreement)
        tvAgreement.setOnClickListener {
            val url = "https://greensaver.vercel.app/about"
            Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
                startActivity(it)
            }
        }
        val editTextPassword = findViewById<EditText>(R.id.et_password)
        val imageViewToggle = findViewById<ImageView>(R.id.ic_password)
        val editTextPasswordTwice = findViewById<EditText>(R.id.et_password_twice)
        val imageViewToggleTwice = findViewById<ImageView>(R.id.ic_password_twice)

        imageViewToggle.setOnClickListener {
            // Saat ImageView diklik, ubah tipe input teks
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility(editTextPassword, isPasswordVisible)
            imageViewToggleTwice.setOnClickListener {
                // Saat ImageView diklik, ubah tipe input teks
                isPasswordVisible = !isPasswordVisible
                togglePasswordVisibility(editTextPasswordTwice, isPasswordVisible)
            }
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