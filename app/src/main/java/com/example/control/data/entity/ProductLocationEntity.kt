package com.example.control.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_location")
data class ProductLocationEntity(
    @PrimaryKey(autoGenerate = true)
    val idProductLocation: Int,
    val idProduct: Int,
    val idLocation: Int,
    val locationName: String,
    val productName: String,
    val skuCode: String,
    val quantity: Int
)
