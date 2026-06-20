package com.example.control.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.control.auxiliar.ReviewDetailWithInfo
import com.example.control.data.entity.ReviewDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDetailDao {
    @Insert
    suspend fun insertDetail(detail: ReviewDetailEntity): Long

    @Update
    suspend fun updateDetail(detail: ReviewDetailEntity)

    @Delete
    suspend fun deleteDetail(detail: ReviewDetailEntity)

    @Query("SELECT * FROM review_detail WHERE idDetail = :id")
    suspend fun getDetailById(id: Int): ReviewDetailEntity?

    @Query("""
        SELECT rd.*, p.name AS product_name, p.skuCode, l.name AS location_name 
        FROM review_detail rd 
        INNER JOIN product p ON rd.idProduct = p.idProduct 
        INNER JOIN location l ON rd.idLocation = l.idLocation 
        WHERE rd.idReview = :reviewId
    """)
    fun getDetailByReview(reviewId: Int): Flow<List<ReviewDetailWithInfo>>
}