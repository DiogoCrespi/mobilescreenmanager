package com.ScreenManager.mobilescreenmanager.service

import android.app.Service
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.IBinder
import android.provider.Settings
import androidx.core.app.NotificationCompat
import com.ScreenManager.mobilescreenmanager.R

class ScreenManagerService : Service() {
    companion object {
        const val ACTION_CHANGE_ORIENTATION = "com.ScreenManager.ACTION_CHANGE_ORIENTATION"
        const val EXTRA_ORIENTATION = "orientation"
        const val EXTRA_AUTO_ROTATE = "auto_rotate"
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_CHANGE_ORIENTATION -> handleOrientationChange(intent)
        }

        startForeground(1, createNotification())
        return START_STICKY
    }

    private fun handleOrientationChange(intent: Intent) {
        val isAutoRotate = intent.getBooleanExtra(EXTRA_AUTO_ROTATE, false)
        if (isAutoRotate) {
            try {
                Settings.System.putInt(
                    contentResolver,
                    Settings.System.ACCELEROMETER_ROTATION,
                    1
                )
            } catch (e: SecurityException) {
                // Tratar erro de permissão
            }
        } else {
            val orientation = intent.getIntExtra(EXTRA_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
            // Implementar lógica de mudança de orientação
        }
    }

    private fun createNotification() = NotificationCompat.Builder(this, "screen_manager")
        .setContentTitle("Screen Manager Ativo")
        .setContentText("Gerenciando orientação da tela")
        .setSmallIcon(R.drawable.ic_screen_rotation)
        .setPriority(NotificationCompat.PRIORITY_LOW)
        .build()
} 