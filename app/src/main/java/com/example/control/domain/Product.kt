package com.example.control.domain

data class Product (
    val idProduct : Int,
    val idCategory : Int,
    val name : String,
    val description : String,
    val skuCode : String,
    val imageUri : String,
    val minStock : Int,
    val active : Boolean,
    val createdAt : Int
)