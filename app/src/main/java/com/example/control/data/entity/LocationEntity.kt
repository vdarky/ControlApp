package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class LocationEntity (
    @PrimaryKey(autoGenerate = true)
    val idLocation : Int,
    val name : String,
    val description : String
)