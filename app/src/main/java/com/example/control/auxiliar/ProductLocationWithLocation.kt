package com.example.control.auxiliar

data class ProductLocationWithLocation(
    val idProductLocation: Int,
    val idProduct: Int,
    val idLocation: Int,
    val quantity: Int,
    val location_name: String   // coincide con el alias 'location_name'
)