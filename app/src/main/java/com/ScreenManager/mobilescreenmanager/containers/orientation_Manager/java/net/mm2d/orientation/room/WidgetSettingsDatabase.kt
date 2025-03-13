/*
 * Copyright (c) 2023 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.room.WidgetSettingConverter
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.room.WidgetSettingEntity
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.room.WidgetSettingsDao

@Database(entities = [WidgetSettingEntity::class], version = 1)
@TypeConverters(WidgetSettingConverter::class)
abstract class WidgetSettingsDatabase : RoomDatabase() {
    abstract fun widgetSettingsDao(): WidgetSettingsDao
}
