package com.example.control.auxiliar

data class ProductLocationWithProduct(
    val idProductLocation: Int,
    val idProduct: Int,
    val idLocation: Int,
    val quantity: Int,
    val product_name: String,   // alias de p.name
    val skuCode: String         // coincide con la columna skuCode de ProductEntity
)