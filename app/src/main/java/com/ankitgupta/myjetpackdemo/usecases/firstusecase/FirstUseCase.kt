package com.ankitgupta.myjetpackdemo.usecases.firstusecase

import com.ankitgupta.myjetpackdemo.usecases.repository.Repository
import javax.inject.Inject

data class FirstUseCase(val repository: Repository) {

    suspend fun isOnBoard(a: Boolean) {
        repository.isOnBoard(a)
    }

}
