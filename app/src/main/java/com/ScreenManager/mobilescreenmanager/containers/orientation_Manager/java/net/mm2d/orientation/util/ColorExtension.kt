/*
 * Copyright (c) 2020 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.util

fun Int.alpha(): Int =
    this.ushr(24) and 0xFF

fun Int.opaque(): Int =
    this or 0xFF.shl(24)
