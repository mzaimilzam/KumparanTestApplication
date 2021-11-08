package com.mzaimilzam.core.utils

import androidx.room.TypeConverter

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object ConvertList {
//
//    @TypeConverter
//    fun fromList(value : List<String>) = Json.encodeToString(value)
//
//    @TypeConverter
//    fun toList(value: String) = Json.decodeFromString<List<String>>(value)

    @TypeConverter
    fun stringAsStringList(strings: String?): List<String> {
        val list = mutableListOf<String>()
        strings
            ?.split(",")
            ?.forEach {
                list.add(it)
            }

        return list
    }

    @TypeConverter
    fun stringListAsString(strings: List<String>?): String {
        var result = ""
        strings?.forEach { element ->
            result += "$element,"
        }
        return result.removeSuffix(",")
    }
}