package com.ScreenManager.mobilescreenmanager.containers.fullscreencardviewpager

import androidx.viewpager2.widget.ViewPager2

class ViewPagerCardChangeListener(private val onPageSelected: (position: Int) -> Unit) :
    ViewPager2.OnPageChangeCallback() {

    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        onPageSelected(position)
    }
}
