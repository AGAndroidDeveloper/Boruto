package com.ankitgupta.myjetpackdemo.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ankitgupta.myjetpackdemo.db.room.typeconverter.DatabaseConverter
import com.ankitgupta.myjetpackdemo.model.Hero
import com.ankitgupta.myjetpackdemo.model.RemoteKeys

@Database(entities = [Hero::class,RemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class RoomDataBase : RoomDatabase() {
    abstract fun dao(): BorutoDao


}