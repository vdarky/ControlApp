package com.example.control.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    //@ColumnInfo(idUser = "id_user")
    val idUser : Int =0,
    @ColumnInfo(name = "name")
    val name : String,
    //@ColumnInfo(pinHash = "pin_hash")
    val pinHash : String
    //, val created_at : Int
)