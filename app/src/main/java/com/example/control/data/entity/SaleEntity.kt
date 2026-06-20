package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "sale")
data class SaleEntity (
    @PrimaryKey(autoGenerate = true)
    val idSale : Int,
    //@ForeignKey
    val idProduct : Int,
    //@ForeignKey
    val idLocation : Int,
    val quantity : Int,
    val salePrice : Int,
    val saleDate : Int, //revisar
    val note : String
)
