package com.example.control.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_location")
data class ProductLocationEntity(
    @PrimaryKey(autoGenerate = true)
    val idProductLocation : Int,
    //@ColumnInfo()
    val idProduct : Int,
    val idLocation : Int,
    val quantity : Int
)
