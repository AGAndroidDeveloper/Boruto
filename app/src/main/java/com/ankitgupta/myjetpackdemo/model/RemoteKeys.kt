package com.ankitgupta.myjetpackdemo.model

import androidx.room.Entity
import com.ankitgupta.myjetpackdemo.Constant.REMOTE_KEY_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName =REMOTE_KEY_TABLE )
data class RemoteKeys(
    val id: Int,
    val previousKeys: Int,
    val nextKeys: Int
) {
}