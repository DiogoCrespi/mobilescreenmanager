package com.ScreenManager.mobilescreenmanager.containers.orientation_manager

import android.app.Service
import android.content.Intent
import android.os.IBinder

class OrientationService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val newOrientation = intent?.getIntExtra("orientation", -1) ?: return START_NOT_STICKY
        val controller = OrientationController(this)
        when (newOrientation) {
            0 -> controller.setOrientationPortrait()
            1 -> controller.setOrientationLandscape()
            2 -> controller.setOrientationReversePortrait()
            3 -> controller.setOrientationReverseLandscape()
            4 -> controller.setOrientationSensor()
            5 -> controller.setOrientationFullSensor()
        }
        return START_STICKY
    }
}
