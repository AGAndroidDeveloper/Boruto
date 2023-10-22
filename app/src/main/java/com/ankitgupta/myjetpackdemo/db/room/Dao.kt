package com.ankitgupta.myjetpackdemo.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ankitgupta.myjetpackdemo.model.Hero

@Dao
interface BorutoDao {

    @Query("SELECT   *  FROM ROOMTABLE ")
    suspend fun getAll(): List<Hero>

    @Query("SELECT * FROM ROOMTABLE Where name= :name1")
    suspend fun searchHero(name1: String): Hero

    @Insert
    suspend fun addHero(heros : List<Hero>)


}