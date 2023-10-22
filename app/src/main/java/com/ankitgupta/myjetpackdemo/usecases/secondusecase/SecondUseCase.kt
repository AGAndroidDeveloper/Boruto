package com.ankitgupta.myjetpackdemo.usecases.secondusecase

import com.ankitgupta.myjetpackdemo.datastore.DataStoreFunctions
import com.ankitgupta.myjetpackdemo.usecases.UseCases
import com.ankitgupta.myjetpackdemo.usecases.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class SecondUseCase(val repository: Repository) {

    fun returnUseCases() :Flow<Boolean?>{
       return repository.returnOnBoard()
    }



}