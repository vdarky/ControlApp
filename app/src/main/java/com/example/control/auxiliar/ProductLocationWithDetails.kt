package com.example.control.auxiliar

data class ProductLocationWithDetails(
    val idProductLocation: Int,
    val idProduct: Int,
    val idLocation: Int,
    val quantity: Int,
    val productName: String,
    val skuCode: String,
    val locationName: String
)