package com.example.control.data.repository

import com.example.control.data.dao.CostHistoryDao
import com.example.control.domain.CostHistory
import com.example.control.data.entity.CostHistoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CostHistoryRepository(
    private val costHistoryDao: CostHistoryDao
) {
    //Insert
    suspend fun insertCost(history: CostHistory) {
        costHistoryDao.insertCost(history.toEntity())
    }

    //Query
    suspend fun getCurrentCost(productId: Int): CostHistory? {
        return costHistoryDao.getCurrentCost(productId)?.toDomain()
    }

    //Query
    fun getCostHistory(productId: Int): Flow<List<CostHistory>> {
        return costHistoryDao.getCostHistory(productId).map { entities ->
            entities.map { it.toDomain() }
        }
    }
}

// Mappers
fun CostHistoryEntity.toDomain() = CostHistory(idCostHistory, idProduct, costValue, effectiveDate, note)
fun CostHistory.toEntity() = CostHistoryEntity(idCostHistory, idProduct, costValue, effectiveDate, note)
