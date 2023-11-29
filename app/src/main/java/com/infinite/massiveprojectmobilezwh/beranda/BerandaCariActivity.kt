package com.infinite.massiveprojectmobilezwh.beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.infinite.massiveprojectmobilezwh.R

class BerandaCariActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_cari)
        replaceFragment(BerandaCariFragment())
        val fl:ConstraintLayout = findViewById(R.id.fragment_container)
        fl.removeAllViews()

        Handler(Looper.getMainLooper()).postDelayed({
            replaceFragment(BerandaProsesFragment())
        },1500)

    }
    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}