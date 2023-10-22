package com.ankitgupta.myjetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitgupta.myjetpackdemo.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WelComeViewModel@Inject constructor(private val useCases: UseCases) :ViewModel() {
     fun isOnBoard(a :Boolean){
         viewModelScope.launch {
             useCases.firstUseCases.isOnBoard(a)
         }

    }

}