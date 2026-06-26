package com.example.control.model.domain

data class Sale(
    val idSale: Int = 0,
    val idProduct: Long,
    val idLocation: Long,
    val quantity: Int,
    val salePrice: Double,
    val saleDate: Int,
    val note: String?,
    val productName: String,
    val locationName: String
)