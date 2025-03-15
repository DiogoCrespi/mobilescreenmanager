package com.ScreenManager.mobilescreenmanager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ScreenManager.mobilescreenmanager.containers.PresentationManager

class MainActivity : AppCompatActivity() {
    private lateinit var presentationManager: PresentationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        presentationManager = PresentationManager(this)
        presentationManager.showOnSecondaryDisplay()
    }

    override fun onDestroy() {
        super.onDestroy()
        presentationManager.dismiss()
    }
}
