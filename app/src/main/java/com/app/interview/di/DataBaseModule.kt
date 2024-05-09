package com.app.interview.di

import android.content.Context
import androidx.room.Room
import com.app.interview.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDB(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "AppDataBase").build()
    }
}