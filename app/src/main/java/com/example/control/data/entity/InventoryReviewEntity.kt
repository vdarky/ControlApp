package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "inventory_review",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["idUser"],
            childColumns = ["idUser"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("idUser")]
)
data class InventoryReviewEntity (
    @PrimaryKey(autoGenerate = true)
    val idReview : Int,
    val idUser : Int,
    val startDate : Long,
    val endDate : Long,
    val status : String,
    val notes : String
    )