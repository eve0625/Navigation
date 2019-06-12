package com.eve0625.navigation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.eve0625.navigation.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var mCurrentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        } //else인 경우 onRestoreInstanceState에서 처리

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    /**
     * 최초 생성시와 복구시에 호출한다.
     */
    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        val navGraphIds = listOf(R.navigation.home, R.navigation.search, R.navigation.library, R.navigation.mypage)

        // 네비게이션뷰에 네비게이션 그래프 목록을 설정
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        // 선택된 네비게이션 컨트롤러가 변경되었을때, action bar에 적용
        controller.observe(this, Observer { navController ->
            setupActionBarWithNavController(navController)
        })

        mCurrentNavController = controller
    }

}
