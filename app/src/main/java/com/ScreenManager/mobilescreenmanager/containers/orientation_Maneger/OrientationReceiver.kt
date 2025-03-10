package com.ScreenManager.mobilescreenmanager.containers.orientation_manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class OrientationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "com.ScreenManager.ORIENTATION_CHANGE") {
            val newOrientation = intent.getIntExtra("orientation", -1)
            val controller = OrientationController(context)
            when (newOrientation) {
                0 -> controller.setOrientationPortrait()
                1 -> controller.setOrientationLandscape()
                2 -> controller.setOrientationReversePortrait()
                3 -> controller.setOrientationReverseLandscape()
                4 -> controller.setOrientationSensor()
                5 -> controller.setOrientationFullSensor()
            }
        }
    }
}
