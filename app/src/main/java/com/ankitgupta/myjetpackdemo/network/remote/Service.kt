package com.ankitgupta.myjetpackdemo.network.remote

import com.ankitgupta.myjetpackdemo.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SerVice1  {

    @GET("/boruto/heros")
    suspend fun getAllHero(
        @Query("page")
        page :Int = 1
    ): Call<ApiResponse>

    @GET("/boruto/search/heros")
    suspend fun getHero(
        @Query("name")
        name: String
    ): Call<ApiResponse>

}