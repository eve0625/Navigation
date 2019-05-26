package com.eve0625.navigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                textMessage.setText(R.string.main_nav_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                textMessage.setText(R.string.main_nav_search)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_library -> {
                textMessage.setText(R.string.main_nav_library)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_mypage -> {
                textMessage.setText(R.string.main_nav_mypage)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        //custom font programmatically
        textMessage.typeface = ResourcesCompat.getFont(this, R.font.notosans_kr_bold)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
