package com.example.control.data.repository

import com.example.control.data.dao.ProductDao
import com.example.control.data.entity.ProductEntity
import com.example.control.domain.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepository (
    private val productDao: ProductDao
){
    //Insert
    suspend fun insertProduct(product: Product){
        productDao.insertProduct(product.toEntity())
    }
    //Update
    suspend fun updateProduct(product: Product){
        productDao.updateProduct(product.toEntity())
    }
    //Query
    suspend fun desactiveProduct(id: Int){
        return productDao.desactiveProduct(id)
    }
    //Query
    suspend fun getProductById(id: Int): Product?{
        return productDao.getProductById(id)?.toDomain()
    }
    //Query
    suspend fun getProductBySku(sku: String): Product?{
        return productDao.getProductBySku(sku)?.toDomain()
    }
    //Query
    fun getActiveProducts(): Flow<List<Product>>{
        return productDao.getActiveProducts().map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
    //Query
    fun getProductsByCategory(categoryId: Int): Flow<List<Product>>{
        return productDao.getProductsByCategory(categoryId).map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
    fun searchProducts(query: String): Flow<List<Product>>{
        return productDao.searchProducts(query).map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
}

// Mappers
fun ProductEntity.toDomain() = Product(idProduct, idCategory, name, description, skuCode, imageUri, minStock, active, createdAt)
fun Product.toEntity() = ProductEntity(idProduct, idCategory, name, description, skuCode, imageUri, minStock, active, createdAt)
