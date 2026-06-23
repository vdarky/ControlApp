package com.example.control.auxiliar

import androidx.room.ColumnInfo

data class ReviewDetailWithInfo (
    val idDetail: Int,
    val idReview: Int,
    val idProduct: Int,
    val idLocation: Int,
    val systemStock: Int,
    val physicalStock: Int,
    val difference: Int,
    val note: String,

    // Estos deben coincidir con los alias de la query o con @ColumnInfo
    @ColumnInfo(name = "product_name") val productName: String,
    // Si tu query usa "skuCode" (sin guión bajo) entonces no necesita @ColumnInfo, o ponlo para claridad
    @ColumnInfo(name = "skuCode") val skuCode: String,  // o si es sku_code, cambia el nombre
    @ColumnInfo(name = "location_name") val locationName: String
)
