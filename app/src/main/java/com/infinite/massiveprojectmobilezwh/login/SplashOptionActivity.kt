package com.infinite.massiveprojectmobilezwh.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.beranda.BerandaListActivity

class SplashOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_option)

        val btn_pelanggan = findViewById<Button>(R.id.myButton)
        val btn_pengepul = findViewById<Button>(R.id.myButton1)

        btn_pelanggan.setOnClickListener {
            Intent(this, DaftarActivity::class.java).also {
                startActivity(it)
            }
        }
        btn_pengepul.setOnClickListener {
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }
        if (isUserLoggedIn() && isRememberCheckBoxChecked()) {
            toHome("")
        }

    }

    private fun isRememberCheckBoxChecked(): Boolean {
        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
        return sharedPreferences.getBoolean("rememberCheckBox", false)    }
    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
        val bearerToken = sharedPreferences.getString("bearerToken", null)
        return !bearerToken.isNullOrBlank()
    }

    private fun toHome(username: String?) {
        Log.d("UserToHome", "User: $username")
        val intent = Intent(this, BerandaListActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}