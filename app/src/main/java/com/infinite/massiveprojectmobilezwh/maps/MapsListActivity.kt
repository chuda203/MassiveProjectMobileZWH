package com.infinite.massiveprojectmobilezwh.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.infinite.massiveprojectmobilezwh.order.OrderListFragment
import com.infinite.massiveprojectmobilezwh.profile.ProfileListFragment
import com.infinite.massiveprojectmobilezwh.R
import com.infinite.massiveprojectmobilezwh.chat.ChatListFragment

class MapsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_list)

        // Cek apakah Intent membawa informasi fragment yang akan ditampilkan
        // Buat atur fragment_container nampilin fragment_order_list
        if (intent.hasExtra("fragmentToLoad")) {
            val fragmentToLoad = intent.getStringExtra("fragmentToLoad")
            when (fragmentToLoad) {
                "OrderListFragment" -> replaceFragment(OrderListFragment())
            }
        } else {
            replaceFragment(MapsListFragment())
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){

                R.id.maps -> replaceFragment(MapsListFragment())
                R.id.order -> replaceFragment(OrderListFragment())
                R.id.chat -> replaceFragment(ChatListFragment())
                R.id.profile -> replaceFragment(ProfileListFragment())
                else ->{
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
    }