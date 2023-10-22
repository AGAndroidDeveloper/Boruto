package com.ankitgupta.myjetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitgupta.myjetpackdemo.model.ApiResponse
import com.ankitgupta.myjetpackdemo.repository.BorutoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(val repository: BorutoRepository) : ViewModel() {


    private val _mresponseData = MutableLiveData<ApiResponse>()
    private val mresponseLiveData: LiveData<ApiResponse> = _mresponseData


    fun getAllHeros(): LiveData<ApiResponse> {
        viewModelScope.launch {
            _mresponseData.value = repository.getAllHero().value

        }
        return mresponseLiveData
    }


}