package com.app.interview.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.interview.data.model.University

@Dao
interface UniversityDao {
    @Query("SELECT * FROM universities")
    suspend fun getAllUniversities(): List<University>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversities(universities: List<University>)
}