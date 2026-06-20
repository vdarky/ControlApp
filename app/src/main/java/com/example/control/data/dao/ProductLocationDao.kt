package com.example.control.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.control.data.entity.ProductLocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductLocationDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertStock(stock: ProductLocationEntity): Long

    @Update
    suspend fun updateStock(stock: ProductLocationEntity)

    @Delete
    suspend fun deleteStock(stock: ProductLocationEntity)

    @Query("SELECT * FROM product_location WHERE idProduct = :productId AND idLocation = :locationId LIMIT 1")
    suspend fun getStock(productId: Int, locationId: Int): ProductLocationEntity?

    @Query("SELECT COALESCE(quantity, 0) FROM product_location WHERE idProduct = :productId")
    suspend fun getTotalStockByProduct(productId: Int): Int

    @Query("" +
            "SELECT COALESCE(quantity, 0) FROM product_location WHERE idProduct = :productId AND idLocation = :locationId")
    suspend fun getQuantityAtLocation(productId: Int, locationId: Int): Int

    @Query("""
        SELECT pl.*, l.name AS location_name 
        FROM product_location pl 
        INNER JOIN location l ON pl.idLocation = l.idLocation 
        WHERE pl.idProduct = :productId
        """)
    fun getStockDetailsByProduct(productId: Int): Flow<List<ProductLocationWithLocation>>


}