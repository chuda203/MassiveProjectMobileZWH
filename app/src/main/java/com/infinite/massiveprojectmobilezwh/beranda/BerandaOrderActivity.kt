package com.infinite.massiveprojectmobilezwh.beranda

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.infinite.massiveprojectmobilezwh.R

class BerandaOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_order)

        // kembali ke Activity sebelumnya
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        btnBack.setOnClickListener {
            // akhiri Activity, alternatif onBackPressed
            finish()
        }

        // Intent ke proses pencarian pengepul
        val btnConfrim = findViewById<Button>(R.id.bt_confirmation)
        btnConfrim.setOnClickListener {
            Intent(this, BerandaCariActivity::class.java).also {
                startActivity(it)
            }
        }

        // Buat dropdown kategori
        val items = listOf("Kaleng", "Plastik", "Besi", "Elektronik")
        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->
        }

        // Di onCreate atau di suatu tempat sesuai kebutuhan
        val imageView: ImageView = findViewById(R.id.imageView)

// Periksa apakah ada data path gambar yang dikirimkan melalui Intent
        if (intent.hasExtra("PHOTO_PATH")) {
            val photoPath = intent.getStringExtra("PHOTO_PATH")
            imageView.setImageURI(Uri.parse(photoPath))
        }

        // Membaca alamat dari SharedPreferences dan menggantikan teks pada tv_maps_detail
        val tvMapsDetail: TextView = findViewById(R.id.tv_maps_detail)
        val savedAddress = getAddressFromSharedPreferences()
        if (savedAddress != null) {
//            autoComplete.setText(savedAddress)
            tvMapsDetail.text = savedAddress
        }

    }
    // Fungsi untuk membaca alamat dari SharedPreferences
    private fun getAddressFromSharedPreferences(): String? {
        val sharedPreferences = getSharedPreferences("Order", AppCompatActivity.MODE_PRIVATE)
        return sharedPreferences.getString("ADDRESS", null)
    }
}