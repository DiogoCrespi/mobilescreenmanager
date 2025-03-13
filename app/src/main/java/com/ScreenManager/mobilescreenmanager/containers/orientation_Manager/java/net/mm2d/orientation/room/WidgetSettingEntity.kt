/*
 * Copyright (c) 2023 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.parcelize.Parcelize
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.control.FunctionButton
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.control.FunctionButton.Companion.toFunctionButtons
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.control.FunctionButton.Companion.toSerializedString
import com.ScreenManager.mobilescreenmanager.containers.orientation_Manager.java.net.mm2d.orientation.settings.IconShape

@Entity(tableName = "widget_settings")
@Parcelize
data class WidgetSettingEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "foreground")
    val foreground: Int,
    @ColumnInfo(name = "background")
    val background: Int,
    @ColumnInfo(name = "foregroundSelected")
    val foregroundSelected: Int,
    @ColumnInfo(name = "backgroundSelected")
    val backgroundSelected: Int,
    @ColumnInfo(name = "base")
    val base: Int,
    @ColumnInfo(name = "shape")
    val shape: IconShape,
    @ColumnInfo(name = "functions")
    val functions: List<FunctionButton>,
) : Parcelable

class WidgetSettingConverter {
    @TypeConverter
    fun shapeToString(shape: IconShape): String = shape.name

    @TypeConverter
    fun shapeFromString(string: String): IconShape = IconShape.of(string)

    @TypeConverter
    fun functionsToString(functions: List<FunctionButton>): String = functions.toSerializedString()

    @TypeConverter
    fun functionsFromString(string: String): List<FunctionButton> = string.toFunctionButtons()
}
