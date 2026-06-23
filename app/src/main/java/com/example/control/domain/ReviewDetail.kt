package com.example.control.domain

data class ReviewDetail (
    val idDetail : Int,
    val idReview : Int,
    val idProduct : Int,
    val idLocation : Int,
    val systemStock : Int,
    val physicalStock : Int,
    val difference : Int,
    val note : String
)