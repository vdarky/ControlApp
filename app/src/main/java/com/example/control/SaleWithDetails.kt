package com.example.control

data class SaleWithDetails(
    val idSale: Int,
    val idProduct: Int,
    val idLocation: Int,
    val quantity: Int,
    val salePrice: Int,
    val saleDate: Int,
    val note: String,
    val product_name: String,   // alias de p.name
    val location_name: String   // alias de l.name
)