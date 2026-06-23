package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "review_detail")
data class ReviewDetailEntity (
    @PrimaryKey(autoGenerate = true)
    val idDetail : Int,
    //@ForeignKey
    val idReview : Int,
    //@ForeignKey
    val idProduct : Int,
    //@ForeignKey
    val idLocation : Int,
    val systemStock : Int,
    val physicalStock : Int,
    val difference : Int,
    val note : String,
    val productName: String,
    val skuCode: String,
    val locationName: String
)