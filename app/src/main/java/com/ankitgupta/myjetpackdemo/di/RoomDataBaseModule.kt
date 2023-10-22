package com.ankitgupta.myjetpackdemo.di

import android.content.Context
import androidx.room.Room
import com.ankitgupta.myjetpackdemo.Constant.BORUTO_DATABASE
import com.ankitgupta.myjetpackdemo.db.room.RoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    fun provideDataBaseInstance(
        @ApplicationContext
        context: Context,
    ) = Room.databaseBuilder(
            context, RoomDataBase::class.java, BORUTO_DATABASE
    ).build()
}