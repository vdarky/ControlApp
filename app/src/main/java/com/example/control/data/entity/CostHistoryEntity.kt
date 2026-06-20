package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "cost_history")
data class CostHistoryEntity (
    @PrimaryKey(autoGenerate = true)
    val idCostHistory : Int,
    //@ForeignKey
    val idProduct : Int,
    val costValue : Int, //revisar si mejor float
    val effectiveDate :Long,
    val note : String
    )