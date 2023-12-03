package com.infinite.massiveprojectmobilezwh.beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.infinite.massiveprojectmobilezwh.profil.ProfilListFragment
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.transaksi.TransaksiListFragment

class BerandaListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_list)
        // atur bottom navigation, aksi setiap klik icon
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_icon -> replaceFragment(BerandaListFragment())
                R.id.transaksi_icon -> replaceFragment(TransaksiListFragment())
                R.id.profile_icon -> replaceFragment(ProfilListFragment())
                else ->{
                }
            }
            true
        }
    }
    // function ganti fragment
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
        }


