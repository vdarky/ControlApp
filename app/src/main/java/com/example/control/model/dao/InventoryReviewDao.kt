package com.example.control.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.control.model.entity.InventoryReviewEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryReviewDao {
    @Insert
    suspend fun insertReview(review: InventoryReviewEntity): Long

    @Update
    suspend fun updateReview(review: InventoryReviewEntity)

    @Query("SELECT * FROM inventory_review WHERE idReview = :id ")
    suspend fun getReviewById(id: Int): InventoryReviewEntity?

    @Query("SELECT * FROM inventory_review ORDER BY startDate DESC")
    fun getAllReviews(): Flow<List<InventoryReviewEntity>>

    @Query("SELECT * FROM inventory_review WHERE status = :status ORDER BY startDate DESC")
    fun getReviewByStatus(status: String): Flow<List<InventoryReviewEntity>>
}