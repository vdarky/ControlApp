package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class InventoryReviewEntity (
    @PrimaryKey(autoGenerate = true)
    val idReview : Int,
    //@ForeignKey
    val idUser : Int,
    val startDate : Int, //Revisar este tipo de dato
    val endDate : Int, //Revisar este tipo de dato
    val status : String,
    val notes : String
    )