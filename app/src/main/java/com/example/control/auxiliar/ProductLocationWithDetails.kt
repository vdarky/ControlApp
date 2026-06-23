package com.example.control.auxiliar

import androidx.room.ColumnInfo

data class ProductLocationWithDetails(
    val idProductLocation: Int,
    val idProduct: Int,
    val idLocation: Int,
    val quantity: Int,

    // Estas vienen del JOIN y sus nombres en BD son con guión bajo
    @ColumnInfo(name = "product_name") val productName: String,
    @ColumnInfo(name = "sku_code") val skuCode: String,
    @ColumnInfo(name = "location_name") val locationName: String
)