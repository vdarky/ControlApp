package com.example.control.auxiliar

import androidx.room.ColumnInfo

data class SaleWithDetails(
    val idSale: Int,
    val idProduct: Int,
    val idLocation: Int,
    val quantity: Int,
    val salePrice: Int,
    val saleDate: Int,
    val note: String?,

    @ColumnInfo(name = "product_name") val productName: String,
    @ColumnInfo(name = "location_name") val locationName: String
)