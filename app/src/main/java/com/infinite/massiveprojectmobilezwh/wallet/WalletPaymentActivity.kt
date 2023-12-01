package com.infinite.massiveprojectmobilezwh.wallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.infinite.massiveprojectmobilezwh.R

class WalletPaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet_payment)
        val btnBack = findViewById<ImageView>(R.id.back)
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}