package com.example.control.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "product")
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
    val createdAt : Int //Revisar este tipo de dato
)