package com.ScreenManager.mobilescreenmanager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ScreenManager.mobilescreenmanager.containers.fullscreencardviewpager.FullScreenCardViewPager
import com.ScreenManager.mobilescreenmanager.containers.fullscreencardviewpager.FullScreenCardViewPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fullScreenCardViewPager = findViewById<FullScreenCardViewPager>(R.id.fullScreenCardViewPager)
        fullScreenCardViewPager.setAdapter(FullScreenCardViewPagerAdapter())
    }
}
