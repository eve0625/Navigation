package com.eve0625.navigation.main

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.eve0625.navigation.R
import com.eve0625.navigation.main.dummy.DummyContent
import com.eve0625.navigation.main.fragment.HomeFragment
import com.eve0625.navigation.main.fragment.LibraryFragment
import com.eve0625.navigation.main.fragment.MyPageFragment
import com.eve0625.navigation.main.fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeFragment.OnListFragmentInteractionListener {

    private enum class MainTab(val tag: String) {
        HOME("home"),
        SEARCH("search"),
        LIBRARY("library"),
        MYPAGE("mypage")
    }

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                switchFragment(MainTab.HOME)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                switchFragment(MainTab.SEARCH)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_library -> {
                switchFragment(MainTab.LIBRARY)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_mypage -> {
                switchFragment(MainTab.MYPAGE)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private val mainFragments: MutableList<Fragment> = ArrayList<Fragment>().apply {
        add(HomeFragment())
        add(SearchFragment.newInstance())
        add(LibraryFragment.newInstance())
        add(MyPageFragment.newInstance())
    }

    private fun switchFragment(tab: MainTab) {
        supportFragmentManager.beginTransaction()
            .replace(fragment_container.id, mainFragments[tab.ordinal], tab.tag)
            //.addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //custom font programmatically
        //textMessage.typeface = ResourcesCompat.getFont(this, R.font.notosans_kr_bold)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        switchFragment(MainTab.HOME)
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        item?.run {
            Toast.makeText(this@MainActivity, item.content, Toast.LENGTH_LONG).show()
        }
    }
}
