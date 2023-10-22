package com.ankitgupta.myjetpackdemo.di

import android.content.Context
import com.ankitgupta.myjetpackdemo.datastore.DataStoreFunImpl
import com.ankitgupta.myjetpackdemo.datastore.DataStoreFunctions
import com.ankitgupta.myjetpackdemo.usecases.UseCases
import com.ankitgupta.myjetpackdemo.usecases.firstusecase.FirstUseCase
import com.ankitgupta.myjetpackdemo.usecases.repository.Repository
import com.ankitgupta.myjetpackdemo.usecases.secondusecase.SecondUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun DataFunImpl(
        @ApplicationContext
        context: Context
    ): DataStoreFunctions {
        return DataStoreFunImpl(context)

    }

    @Provides
    @Singleton
    fun useCases(repository: Repository): UseCases {
        return UseCases(
                firstUseCases = FirstUseCase(repository),
                secondUseCases = SecondUseCase(repository = repository)

        )

    }

}