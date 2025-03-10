package com.ScreenManager.mobilescreenmanager.containers.orientation_manager

import android.content.Context
import android.content.pm.ActivityInfo
import android.view.Surface
import android.view.WindowManager

class OrientationController(private val context: Context) {

    private val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    fun setOrientationPortrait() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    }

    fun setOrientationLandscape() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
    }

    fun setOrientationReversePortrait() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT)
    }

    fun setOrientationReverseLandscape() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE)
    }

    fun setOrientationSensor() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR)
    }

    fun setOrientationFullSensor() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR)
    }

    fun getCurrentOrientation(): Int {
        return windowManager.defaultDisplay.rotation
    }

    private fun setRequestedOrientation(orientation: Int) {
        if (context is OrientationActivity) {
            context.requestedOrientation = orientation
        }
    }

    fun getScreenRotation(): String {
        return when (windowManager.defaultDisplay.rotation) {
            Surface.ROTATION_0 -> "Portrait"
            Surface.ROTATION_90 -> "Landscape"
            Surface.ROTATION_180 -> "Reverse Portrait"
            Surface.ROTATION_270 -> "Reverse Landscape"
            else -> "Unknown"
        }
    }
}
