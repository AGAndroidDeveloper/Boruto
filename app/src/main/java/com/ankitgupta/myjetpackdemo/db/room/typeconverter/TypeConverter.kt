package com.ankitgupta.myjetpackdemo.db.room.typeconverter

import androidx.room.TypeConverter
import com.ankitgupta.myjetpackdemo.model.Hero
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DatabaseConverter {

    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (item in list) {
            stringBuilder.append(item).append(separator)
        }

        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }


}