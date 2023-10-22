package com.ankitgupta.myjetpackdemo.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ankitgupta.myjetpackdemo.model.ApiResponse
import com.ankitgupta.myjetpackdemo.network.remote.SerVice1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class BorutoRepository @Inject constructor(private val serVice: SerVice1) {
    private val _responseData = MutableLiveData<ApiResponse>()
    private val responseLiveData: LiveData<ApiResponse> = _responseData


    suspend fun getAllHero(): LiveData<ApiResponse> {

        val call = serVice.getAllHero()
        try {
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        _responseData.value = response.body()

                    } else {
                        Log.e("responseERR", response.message())
                    }

                }
                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e("callbackERR", "$t")
                }
            }
            )

        } catch (e: Exception) {
            Log.e("ERR", "${e.message}")


        }

        return responseLiveData

    }

}