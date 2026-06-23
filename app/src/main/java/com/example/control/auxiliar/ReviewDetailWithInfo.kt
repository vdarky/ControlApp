package com.example.control.auxiliar

data class ReviewDetailWithInfo (
    val idDetail: Int,
    val idReview: Int,
    val idProduct: Int,
    val idLocation: Int,
    val systemStock: Int,
    val physicalStock: Int,
    val difference: Int,
    val note: String,
    val productName: String,
    val skuCode: String,
    val locationName: String
)