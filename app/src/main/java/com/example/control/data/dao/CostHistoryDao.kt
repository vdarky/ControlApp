package com.example.control.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.control.data.entity.CostHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CostHistoryDao {
    @Insert
    suspend fun insertCost(history: CostHistoryEntity): Long

    @Query("""
        SELECT * FROM cost_history 
        WHERE idProduct = :productId 
        ORDER BY effectiveDate DESC LIMIT 1
    """)
    suspend fun getCurrentCost(productId: Int): CostHistoryEntity?

    @Query("""
        SELECT * FROM cost_history 
        WHERE idProduct = :productId 
        ORDER BY effectiveDate DESC
    """)
    fun getCostHistory(productId: Int): Flow<List<CostHistoryEntity>>
}