package com.ankitgupta.myjetpackdemo.usecases

import com.ankitgupta.myjetpackdemo.usecases.firstusecase.FirstUseCase
import com.ankitgupta.myjetpackdemo.usecases.secondusecase.SecondUseCase

data class UseCases(
        val firstUseCases: FirstUseCase,
        val secondUseCases: SecondUseCase
)
