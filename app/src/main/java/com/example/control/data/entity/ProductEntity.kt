package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "product",
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["idCategory"],
            childColumns = ["idCategory"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("idCategory")]
)
data class ProductEntity (
    @PrimaryKey(autoGenerate = true)
    val idProduct : Int,
    //@ForeignKey
    val idCategory : Int,
    val name : String,
    val description : String,
    val skuCode : String,
    val imageUri : String,
    val minStock : Int,
    val active : Boolean,
    val createdAt : Long
)