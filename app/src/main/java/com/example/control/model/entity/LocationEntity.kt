package com.example.control.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class LocationEntity (
    @PrimaryKey(autoGenerate = true)
    val idLocation : Int =0,
    val name : String,
    val description : String
)