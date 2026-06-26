package com.example.control.model.domain

data class ProductLocation(
    val idProductLocation : Int,
    val idProduct : Int,
    val idLocation : Int,
    val quantity : Int,
    val productName: String,
    val skuCode: String,
    val locationName: String
)
