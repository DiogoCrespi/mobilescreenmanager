package com.ScreenManager.mobilescreenmanager.containers.fullscreencardviewpager

import android.content.Context
import android.util.TypedValue

object PresentationUtils {

    fun convertDpToPixel(dp: Int, context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}
