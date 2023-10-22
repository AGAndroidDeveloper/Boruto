package com.ankitgupta.myjetpackdemo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitgupta.myjetpackdemo.usecases.UseCases
import com.ankitgupta.myjetpackdemo.usecases.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val useCase : UseCases):ViewModel() {
     private var  a1 = MutableStateFlow(false)
       val  b : StateFlow<Boolean> = a1

     init {
         viewModelScope.launch {
           useCase.secondUseCases.returnUseCases().collect {
               if (it != null) {
                   a1.value = it
               }
           }
         }

     }

}