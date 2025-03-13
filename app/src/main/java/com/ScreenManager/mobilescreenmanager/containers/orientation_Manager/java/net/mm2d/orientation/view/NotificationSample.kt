/*
 * Copyright (c) 2018 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.view

import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.core.view.isVisible
import net.mm2d.android.orientationfaker.R
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.control.FunctionButton
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.control.FunctionButton.OrientationButton
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.control.Functions
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.settings.DesignPreference
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.settings.OrientationPreference
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.util.alpha
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.util.opaque
import net.mm2d.orientation.view.widget.ViewIds

class NotificationSample(view: View) {
    val buttonList: List<ButtonViews> = ViewIds.notification.map {
        ButtonViews(
            view.findViewById(it.buttonId),
            view.findViewById(it.iconId),
            view.findViewById(it.shapeId),
            OrientationButton.UNSPECIFIED,
        )
    }
    private val base = view.findViewById<View>(R.id.notification)

    fun update(orientation: OrientationPreference, design: DesignPreference) {
        base.setBackgroundColor(design.base)
        val functions = design.functions
        functions.forEachIndexed { index, value ->
            val button = buttonList[index]
            Functions.find(value)?.let {
                button.icon.setImageResource(it.icon)
                button.function = value
            }
        }
        val iconShape = design.shape
        val selectedOrientation = orientation.orientation
        buttonList.forEachIndexed { index, it ->
            it.shape.setImageResource(iconShape.iconId)
            if (it.function.orientation == selectedOrientation) {
                it.shape.setImageColor(design.backgroundSelected)
                it.icon.setImageColor(design.foregroundSelected)
            } else {
                it.shape.setImageColor(design.background)
                it.icon.setImageColor(design.foreground)
            }
            it.button.isVisible = index < functions.size
        }
    }

    private fun ImageView.setImageColor(@ColorInt color: Int) {
        setColorFilter(color.opaque())
        imageAlpha = color.alpha()
    }

    class ButtonViews(
        val button: View,
        val icon: ImageView,
        val shape: ImageView,
        var function: FunctionButton,
    )
}
