package com.example.control.domain

data class InventoryReview (
    val idReview : Int =0,
    val idUser : Int,
    val startDate : Int,
    val endDate : Int,
    val status : String,
    val notes : String?
)