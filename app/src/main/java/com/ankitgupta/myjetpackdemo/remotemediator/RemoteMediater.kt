package com.ankitgupta.myjetpackdemo.remotemediator

import retrofit2.Callback
import android.util.Log
import androidx.datastore.preferences.protobuf.Api
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.ankitgupta.myjetpackdemo.db.room.RoomDataBase
import com.ankitgupta.myjetpackdemo.model.ApiResponse
import com.ankitgupta.myjetpackdemo.model.Hero
import com.ankitgupta.myjetpackdemo.network.remote.SerVice1
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class RemoteMediater@Inject constructor(private val service :SerVice1, val roomDb : RoomDataBase)
    :RemoteMediator<Int,Hero>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        var  response1  :ApiResponse? = null
        try {
            val page :Int =1
            val call = service.getAllHero(page)
            call.enqueue(object :Callback<ApiResponse>{
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful){
                        response1  = response.body()



                    }else{

                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                   Log.e("err","$t")

                }

            })

            roomDb.dao().addHero(response1!!.heroes)


        }catch (e :Exception){
            Log.e("e","$e")

        }

    }
}