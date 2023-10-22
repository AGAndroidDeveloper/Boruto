package com.ankitgupta.myjetpackdemo.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.ankitgupta.myjetpackdemo.Constant.DATASTORE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = DATASTORE)
class DataStoreFunImpl(private val context: Context) : DataStoreFunctions {
    override suspend fun isOnBoard(boolean: Boolean) {
        context.dataStore.edit {
            it[key] = boolean
        }
    }

    override fun returnOnBoard(): Flow<Boolean?> {
        val data = context.dataStore.data.map {
            it[key]
        }
        return data
    }


    companion object {
        val key = booleanPreferencesKey("KEY")
    }

}