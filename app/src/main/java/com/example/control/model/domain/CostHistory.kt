package com.example.control.model.domain

data class CostHistory (
    val idCostHistory : Int,
    val idProduct : Int,
    val costValue : Float,
    val effectiveDate :Long,
    val note : String?
)