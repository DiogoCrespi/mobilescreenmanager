package com.ScreenManager.mobilescreenmanager.containers.fullscreencardviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import com.ScreenManager.mobilescreenmanager.R

class FullScreenCardViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val viewPager: ViewPager2

    init {
        LayoutInflater.from(context).inflate(R.layout.viewpager_fullscreen, this, true)
        viewPager = findViewById(R.id.viewPager)
    }

    fun setAdapter(adapter: FullScreenCardViewPagerAdapter) {
        viewPager.adapter = adapter
    }

    fun getViewPager(): ViewPager2 = viewPager
}
