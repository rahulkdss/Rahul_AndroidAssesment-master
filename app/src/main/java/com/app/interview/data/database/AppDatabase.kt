package com.app.interview.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.interview.utils.ListStringConverter
import com.app.interview.data.model.University

@Database(entities = [University::class], version = 1)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun universityDao(): UniversityDao
}