package com.example.control.auxiliar

data class SaleWithDetails(
    val idSale: Int,
    val idProduct: Int,
    val idLocation: Int,
    val quantity: Int,
    val salePrice: Int,
    val saleDate: Int,
    val note: String,
    val productName: String,   // alias de p.name
    val locationName: String   // alias de l.name
)