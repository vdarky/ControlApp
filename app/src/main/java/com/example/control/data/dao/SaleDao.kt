package com.example.control.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.control.auxiliar.SaleWithDetails
import com.example.control.data.entity.SaleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SaleDao {
    @Insert
    suspend fun insertSale(sale: SaleEntity):Long

    @Query("""
    SELECT s.*, p.name AS product_name, l.name AS location_name 
    FROM sale s 
    INNER JOIN product p ON s.idProduct = p.idProduct 
    INNER JOIN location l ON s.idLocation = l.idLocation 
    ORDER BY s.saleDate DESC
    """)
    fun getAllSales(): Flow<List<SaleWithDetails>>

    @Query("SELECT * FROM sale WHERE idProduct = :productId ORDER BY saleDate DESC")
    fun getSalesByProduct(productId: Int): Flow<List<SaleEntity>>

    @Query("SELECT * FROM sale WHERE idLocation = :locationId ORDER BY saleDate DESC")
    fun getSalesByLocation(locationId: Int): Flow<List<SaleEntity>>

    @Query("SELECT * FROM sale WHERE saleDate BETWEEN :start AND :end ORDER BY saleDate DESC")
    fun getSalesByDateRange(start: Int, end: Int): Flow<List<SaleEntity>>
}