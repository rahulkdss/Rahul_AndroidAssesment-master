package com.app.interview.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "universities")
data class University(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
//    val state_province: String,
    val web_pages: List<String>
)