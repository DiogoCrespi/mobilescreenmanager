/*
 * Copyright (c) 2020 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.room.PackageSettingEntity
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.room.PackageSettingsDao

@Database(entities = [PackageSettingEntity::class], version = 1)
abstract class PackageSettingsDatabase : RoomDatabase() {
    abstract fun packageSettingsDao(): PackageSettingsDao
}
