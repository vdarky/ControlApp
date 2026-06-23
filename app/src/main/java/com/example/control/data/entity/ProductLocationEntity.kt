package com.example.control.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "product_location",
    foreignKeys = [
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["idProduct"],
            childColumns = ["idProduct"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = LocationEntity::class,
            parentColumns = ["idLocation"],
            childColumns = ["idLocation"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("idProduct"), Index("idLocation")]
)
data class ProductLocationEntity(
    @PrimaryKey(autoGenerate = true)
    val idProductLocation: Int,
    val idProduct: Int,
    val idLocation: Int,
    //val locationName: String,
    //val productName: String,
    //val skuCode: String,
    val quantity: Int
)
