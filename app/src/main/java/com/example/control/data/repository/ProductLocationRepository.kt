package com.example.control.data.repository

import ProductLocationDao
import com.example.control.auxiliar.ProductLocationWithDetails
import com.example.control.data.entity.ProductLocationEntity
import com.example.control.domain.ProductLocation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductLocationRepository (
    private val productLocationDao: ProductLocationDao
){
    //Insert
    suspend fun insertStock(stock: ProductLocation){
        productLocationDao.insertStock(stock.toEntity())
    }
    //Update
    suspend fun updateStock(stock: ProductLocation){
        productLocationDao.updateStock(stock.toEntity())
    }
    //Delete
    suspend fun deleteStock(stock: ProductLocation){
        productLocationDao.deleteStock(stock.toEntity())
    }
    //Query
    suspend fun getStock(productId: Int, locationId: Int): ProductLocation?{
        return productLocationDao.getStock(productId, locationId)?.toDomain()
    }
    //Query
    suspend fun getTotalStockByProduct(productId: Int): Int{
        return productLocationDao.getTotalStockByProduct(productId)
    }
    //Query
    suspend fun getQuantityAtLocation(productId: Int, locationId: Int): Int{
        return productLocationDao.getQuantityAtLocation(productId, locationId)
    }
    //Query
    fun getStockDetailsByProduct(productId: Int): Flow<List<ProductLocation>>{
        return productLocationDao.getStockDetailsByProduct(productId).map{
            entities -> entities.map{
            it.toDomain()
            }
        }
    }
    //Query
    fun getStockDetailsByLocation(locationId: Int): Flow<List<ProductLocation>>{
        return productLocationDao.getStockDetailsByLocation(locationId).map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
}

//Mappers
//  Entity → Domain
fun ProductLocationEntity.toDomain() = ProductLocation(idProductLocation, idProduct, idLocation, quantity, "", "", "")
fun ProductLocation.toEntity() = ProductLocationEntity(idProductLocation, idProduct, idLocation, quantity)
//  Clase auxiliar → Domain
fun ProductLocationWithDetails.toDomain() = ProductLocation(idProductLocation, idProduct, idLocation, quantity, productName, skuCode, locationName)