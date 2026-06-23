package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "cost_history",
    foreignKeys = [
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["idProduct"],
            childColumns = ["idProduct"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("idProduct")]
)
data class CostHistoryEntity (
    @PrimaryKey(autoGenerate = true)
    val idCostHistory : Int = 0,
    val idProduct : Int,
    val costValue : Float,
    val effectiveDate :Long,
    val note : String
)