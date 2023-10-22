package com.ankitgupta.myjetpackdemo.usecases.repository

import com.ankitgupta.myjetpackdemo.datastore.DataStoreFunctions
import javax.inject.Inject

class Repository @Inject constructor(private val dataStoreFunctions: DataStoreFunctions) {

    suspend fun isOnBoard(a :Boolean){
        dataStoreFunctions.isOnBoard(a)
    }

    fun returnOnBoard() :kotlinx.coroutines.flow.Flow<Boolean?>{
        return dataStoreFunctions.returnOnBoard()
    }

}