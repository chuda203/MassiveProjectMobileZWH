package com.infinite.massiveprojectmobilezwh.login

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.Retro
import com.infinite.massiveprojectmobilezwh.UserApi
import com.infinite.massiveprojectmobilezwh.UserRequest
import com.infinite.massiveprojectmobilezwh.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private var isPasswordVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Intent ke login jika sudah punya akun
        val tvLogin = findViewById<TextView>(R.id.tv_login)
        tvLogin.setOnClickListener {
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

        // Aktifkan klik agreement, sementara pake about us dr web
        val tvAgreement = findViewById<TextView>(R.id.tv_agreement)
        tvAgreement.setOnClickListener {
            val url = "https://greensaver.vercel.app/about"
            Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
                startActivity(it)
            }
        }

        // Mengaktifkan fungsi hide dan unhide password
        val imageViewToggle = findViewById<ImageView>(R.id.ic_password)
        val editTextPassword = findViewById<EditText>(R.id.et_password)
        imageViewToggle.setOnClickListener {
            // Saat ImageView diklik, ubah tipe input password
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility(editTextPassword, isPasswordVisible)
        }

        // Mengaktifkan fungsi hide dan unhide konfirmasi password
        val editTextPasswordTwice = findViewById<EditText>(R.id.et_password_twice)
        val imageViewToggleTwice = findViewById<ImageView>(R.id.ic_password_twice)
        imageViewToggleTwice.setOnClickListener {
            // Saat ImageView diklik, ubah tipe input password
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility(editTextPasswordTwice, isPasswordVisible)
        }
        val btnRegis : Button = findViewById(R.id.bt_confirmation)
        btnRegis.setOnClickListener {
            register()
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
    fun register () {
        val etUsername : EditText = findViewById(R.id.et_username)
        val etEmail : EditText = findViewById(R.id.et_phone)
        val etPassword : EditText = findViewById(R.id.et_password)
        val request = UserRequest()
        request.name = etUsername.text.toString().trim()
        request.email = etEmail.text.toString().trim()
        request.password = etPassword.text.toString().trim()

        val retro = Retro().getRetroCLientInstance().create(UserApi::class.java)
        retro.signup(request).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    if (user != null) {
                        toHome()
                    } else {
                        Log.e("Error", "User or data is null")
                    }
                } else {
                    Log.e("Error", "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Error", t.message ?: "Unknown error")
            }

        })
    }

    private fun toHome() {
        Intent(this, LoginActivity::class.java).also {
            startActivity(it)
        }
    }


}