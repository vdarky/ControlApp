package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "sale",
    foreignKeys = [
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["idProduct"],
            childColumns = ["idProduct"],
            onDelete = ForeignKey.RESTRICT
        ),
        ForeignKey(
            entity = LocationEntity::class,
            parentColumns = ["idLocation"],
            childColumns = ["idLocation"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("idProduct"), Index("idLocation")]
)
data class SaleEntity (
    @PrimaryKey(autoGenerate = true)
    val idSale : Int =0,
    val idProduct : Int,
    val idLocation : Int,
    val quantity : Int,
    val salePrice : Int,
    val saleDate : Long, //revisar
    val note : String
)
