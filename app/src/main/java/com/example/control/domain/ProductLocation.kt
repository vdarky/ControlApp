package com.example.control.domain

data class ProductLocation(
    val idProductLocation : Int,
    val idProduct : Int,
    val idLocation : Int,
    val locationName: String,
    val productName: String,
    val skuCode: String,
    val quantity : Int,

)
