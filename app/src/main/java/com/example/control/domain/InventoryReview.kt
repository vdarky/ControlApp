package com.example.control.domain

data class InventoryReview (
    val idReview : Int,
    val idUser : Int,
    val startDate : Int,
    val endDate : Int,
    val status : String,
    val notes : String
)