package com.example.control.model.domain

data class Product (
    val idProduct : Int = 0,
    val idCategory : Long,
    val name : String,
    val description : String?,
    val skuCode : String,
    val imageUri : String?,
    val minStock : Int,
    val active : Boolean,
    val createdAt : Int
)