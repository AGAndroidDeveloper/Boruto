package com.ankitgupta.myjetpackdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ankitgupta.myjetpackdemo.Constant.ROOMTABLE
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = ROOMTABLE)
data class Hero(
    @SerializedName("abilities") val abilities: List<String>,
    @SerializedName("about") val about: String,
    @SerializedName("day") val day: String,
    @SerializedName("family") val family: List<String>,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("month") val month: String,
    @SerializedName("name") val name: String,
    @SerializedName("natureTypes") val natureTypes: List<String>,
    @SerializedName("power") val power: Int,
    @SerializedName("rating") val rating: Double
)