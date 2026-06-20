package com.example.control.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.control.data.entity.InventoryReviewEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryReviewDao {
    @Insert
    suspend fun insertReview(review: InventoryReviewEntity): Long

    @Update
    suspend fun updateReview(review: InventoryReviewDao)

    @Query("SELECT * FROM InventoryReviewEntity WHERE idReview = :id ")
    suspend fun getReviewById(id: Int): InventoryReviewEntity?

    @Query("SELECT * FROM InventoryReviewEntity ORDER BY startDate DESC")
    fun getAllReviews(): Flow<List<InventoryReviewEntity>>

    @Query("SELECT * FROM InventoryReviewEntity WHERE status = :status ORDER BY startDate DESC")
    fun getReviewByStatus(status: String): Flow<List<InventoryReviewEntity>>
}