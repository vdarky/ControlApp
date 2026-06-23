package com.example.control.data.repository

import com.example.control.auxiliar.ReviewDetailWithInfo
import com.example.control.data.dao.ReviewDetailDao
import com.example.control.data.entity.ReviewDetailEntity
import com.example.control.domain.ReviewDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ReviewDetailRepository (
    private val reviewDetailDao: ReviewDetailDao
){
    //Insert
    suspend fun insertDetail(detail: ReviewDetail) {
        reviewDetailDao.insertDetail(detail.toEntity())
    }
    //Update
    suspend fun updateDetail(detail: ReviewDetail){
        reviewDetailDao.updateDetail(detail.toEntity())
    }
    //Delete
    suspend fun deleteDetail(detail: ReviewDetail){
        reviewDetailDao.deleteDetail(detail.toEntity())
    }
    //Query
    suspend fun getDetailById(id: Int): ReviewDetail?{
        return reviewDetailDao.getDetailById(id)?.toDomain()
    }
    //Query
    fun getDetailbyReview(reviewId: Int): Flow<List<ReviewDetail>>{
        return reviewDetailDao.getDetailByReview(reviewId).map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
}
// Mappers
fun ReviewDetailEntity.toDomain() = ReviewDetail(idDetail, idReview, idProduct, idLocation, systemStock, physicalStock, difference, note, "", "", "") // campos vacíos cuando no viene del JOIN)
fun ReviewDetail.toEntity() = ReviewDetailEntity(idDetail, idReview, idProduct, idLocation, systemStock, physicalStock, difference, note, productName, skuCode, locationName)
fun ReviewDetailWithInfo.toDomain() = ReviewDetail(idDetail, idReview, idProduct, idLocation, systemStock, physicalStock, difference, note, productName, skuCode, locationName)