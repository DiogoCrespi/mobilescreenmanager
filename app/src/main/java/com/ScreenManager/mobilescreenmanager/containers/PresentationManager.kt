package com.ScreenManager.mobilescreenmanager.containers

import android.app.Presentation
import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.view.Display
import android.widget.FrameLayout
import com.ScreenManager.mobilescreenmanager.R
import com.ScreenManager.mobilescreenmanager.containers.fullscreencardviewpager.FullScreenCardViewPager
import com.ScreenManager.mobilescreenmanager.containers.orientation_manager.OrientationController

class PresentationManager(private val context: Context) {
    private var currentPresentation: Presentation? = null
    private val displayManager = context.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
    private var orientationController: OrientationController? = null

    fun showOnSecondaryDisplay() {
        val secondaryDisplay = findSecondaryDisplay()
        if (secondaryDisplay != null) {
            showPresentation(secondaryDisplay)
        }
    }

    private fun findSecondaryDisplay(): Display? {
        return displayManager.displays.firstOrNull { it.displayId != Display.DEFAULT_DISPLAY }
    }

    private fun showPresentation(display: Display) {
        currentPresentation?.dismiss()
        
        currentPresentation = object : Presentation(context, display) {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.presentation_layout)

                val container = findViewById<FrameLayout>(R.id.presentation_container)
                val fullScreenCardViewPager = FullScreenCardViewPager(context)
                container.addView(fullScreenCardViewPager)

                orientationController = OrientationController(context)
                // Definir orientação inicial como paisagem para a segunda tela
                orientationController?.setOrientationLandscape()
            }
        }
        
        currentPresentation?.show()
    }

    fun getOrientationController(): OrientationController? = orientationController

    fun dismiss() {
        currentPresentation?.dismiss()
        currentPresentation = null
    }
} 