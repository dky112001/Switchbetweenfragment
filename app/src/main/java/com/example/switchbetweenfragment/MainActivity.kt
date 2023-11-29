package com.example.switchbetweenfragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentcall(HomeFragment())

        val bottomnav = findViewById<BottomNavigationView>(R.id.bottomNav)
            bottomnav.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.home ->{
                 // Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                        fragmentcall(HomeFragment())
                    }R.id.profile ->{
                       // Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                        fragmentcall(ProfileFragment())
                    }R.id.setting ->{
                    //  Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
                    fragmentcall(Settingfragment())
                    }
                }

                true
            }


    }

     fun fragmentcall (fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}