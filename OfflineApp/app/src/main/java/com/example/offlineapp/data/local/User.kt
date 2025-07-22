package com.example.offlineapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String
)

