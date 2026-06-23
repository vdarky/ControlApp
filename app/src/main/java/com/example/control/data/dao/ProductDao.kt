package com.example.control.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.control.data.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: ProductEntity): Long

    @Update
    suspend fun updateProduct(product: ProductEntity)

    @Query("UPDATE product SET active = 0 WHERE idProduct = :id")
    suspend fun desactiveProduct(id:Int)

    @Query("SELECT * FROM product WHERE idProduct = :id")
    suspend fun getProductById(id: Int): ProductEntity?

    @Query("SELECT * FROM product WHERE skuCode = :sku LIMIT 1")
    suspend fun getProductBySku(sku: String): ProductEntity?

    @Query("SELECT * FROM product WHERE active = 1 ORDER BY name ASC")
    fun getActiveProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE idCategory = :categoryId AND active =1")
    fun getProductsByCategory(categoryId: Int): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE (name LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%')AND active = 1")
    fun searchProducts(query: String): Flow<List<ProductEntity>>


}