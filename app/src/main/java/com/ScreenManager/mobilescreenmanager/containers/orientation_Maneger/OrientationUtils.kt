package com.ScreenManager.mobilescreenmanager.containers.orientation_manager

import android.content.Context
import android.view.Surface
import android.view.WindowManager

object OrientationUtils {
    fun getScreenRotation(context: Context): String {
        val rotation = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.rotation
        return when (rotation) {
            Surface.ROTATION_0 -> "Portrait"
            Surface.ROTATION_90 -> "Landscape"
            Surface.ROTATION_180 -> "Reverse Portrait"
            Surface.ROTATION_270 -> "Reverse Landscape"
            else -> "Unknown"
        }
    }
}
