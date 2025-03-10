package com.ScreenManager.mobilescreenmanager.containers.fullscreencardviewpager

import android.app.Service
import android.content.Intent
import android.os.IBinder

class FullScreenService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Lógica para manter o aplicativo em tela cheia ou outras configurações
        return START_STICKY
    }
}
