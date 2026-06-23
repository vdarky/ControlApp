package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "review_detail",
    foreignKeys = [
        ForeignKey(
            entity = InventoryReviewEntity::class,
            parentColumns = ["idReview"],
            childColumns = ["idReview"],
            onDelete = ForeignKey.CASCADE
        ),
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
    indices = [Index("idReview"), Index("idProduct"), Index("idLocation")]
    )
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