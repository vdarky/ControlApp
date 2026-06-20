package com.example.control.auxiliar

data class ReviewDetailWithInfo (
    val idDetail: Int,
    val idReview: Int,
    val idProduct: Int,
    val idLocation: Int,
    val systemStock: Int,
    val physicalStock: Int,
    val difference: Int,
    val note: String?,
    val product_name: String,
    val skuCode: String,
    val location_name: String
)