/*
 * Copyright (c) 2021 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.settings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.control.FunctionButton

@Parcelize
data class DesignPreference(
    val foreground: Int,
    val background: Int,
    val foregroundSelected: Int,
    val backgroundSelected: Int,
    val base: Int,
    val shape: IconShape,
    val functions: List<FunctionButton>,
) : Parcelable
