package com.ScreenManager.mobilescreenmanager.containers.orientation_manager

import android.content.Context
import android.provider.Settings

object OrientationHelper {
    fun isAutoRotationEnabled(context: Context): Boolean {
        return Settings.System.getInt(
            context.contentResolver,
            Settings.System.ACCELEROMETER_ROTATION,
            0
        ) == 1
    }

    fun setAutoRotationEnabled(context: Context, enabled: Boolean) {
        Settings.System.putInt(
            context.contentResolver,
            Settings.System.ACCELEROMETER_ROTATION,
            if (enabled) 1 else 0
        )
    }
}
