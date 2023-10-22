package com.ankitgupta.myjetpackdemo.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreFunctions {

suspend fun isOnBoard(bol :Boolean)

fun returnOnBoard() : Flow<Boolean?>


}