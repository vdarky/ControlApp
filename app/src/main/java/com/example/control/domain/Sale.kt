package com.example.control.domain

data class Sale (
    val idSale : Int,
    val idProduct : Int,
    val idLocation : Int,
    val quantity : Int,
    val salePrice : Int,
    val saleDate : Int,
    val note : String
)