/*
 * Copyright (c) 2021 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.settings

data class ReviewPreference(
    val intervalRandomFactor: Long,
    val firstUseTime: Long,
    val firstReviewTime: Long,
    val orientationChangeCount: Int,
    val cancelCount: Int,
    val reviewed: Boolean,
    val reported: Boolean,
)
