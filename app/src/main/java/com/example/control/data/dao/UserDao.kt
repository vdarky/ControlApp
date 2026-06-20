package com.example.control.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.control.data.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(idUser: UserEntity)

    @Update
    suspend fun update(idUser: UserEntity)

    @Query("SELECT * FROM User LIMIT 1")
    suspend fun getUser():UserEntity?
}