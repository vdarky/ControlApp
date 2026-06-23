package com.example.control.data.repository

import com.example.control.data.dao.InventoryReviewDao
import com.example.control.data.entity.InventoryReviewEntity
import com.example.control.domain.InventoryReview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class InventoryReviewRepository(
    private val inventoryReviewDao: InventoryReviewDao
){
    // Insert
    suspend fun insertReview(inventory: InventoryReview){
        inventoryReviewDao.insertReview(inventory.toEntity())
    }
    //Update
    suspend fun updateReview(inventory: InventoryReview){
        inventoryReviewDao.updateReview(inventory.toEntity())
    }
    //Query
    suspend fun getReviewById(id : Int): InventoryReview?{
        return inventoryReviewDao.getReviewById(id)?.toDomain()
    }
    //Query
    fun getAllReviews(): Flow<List<InventoryReview>>{
        return inventoryReviewDao.getAllReviews().map {
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
    //Query
    fun getReviewByStatus(status: String): Flow<List<InventoryReview>>{
        return inventoryReviewDao.getReviewByStatus(status).map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }

}

// Mappers
fun InventoryReviewEntity.toDomain() = InventoryReview(idReview, idUser, startDate, endDate, status, notes)
fun InventoryReview.toEntity() = InventoryReviewEntity(idReview, idUser, startDate, endDate, status, notes)
