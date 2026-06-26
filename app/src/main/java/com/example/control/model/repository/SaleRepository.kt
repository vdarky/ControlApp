package com.example.control.model.repository

import com.example.control.auxiliar.SaleWithDetails
import com.example.control.model.dao.SaleDao
import com.example.control.model.entity.SaleEntity
import com.example.control.model.domain.Sale
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SaleRepository(
    private val saleDao : SaleDao
){
    //Insert
    suspend fun insertSale(sale: Sale){
        saleDao.insertSale(sale.toEntity())
    }
    //Query
    fun getAllSales(): Flow<List<Sale>> {
        return saleDao.getAllSales().map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
    //Query
    fun getSalesByProduct(productId: Int): Flow<List<Sale>>{
        return saleDao.getSalesByProduct(productId).map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
    //Query
    fun getSalesByLocation(locationId: Int): Flow<List<Sale>>{
        return saleDao.getSalesByLocation(locationId).map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
    //Query
    fun getSalesByDateRange(start: Int, end: Int): Flow<List<Sale>>{
        return saleDao.getSalesByDateRange(start, end).map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
}
//Mappers
fun SaleEntity.toDomain() = Sale(
    idSale = idSale,
    idProduct = idProduct.toLong(),
    idLocation = idLocation.toLong(),
    quantity = quantity,
    salePrice = salePrice.toDouble(),
    saleDate = saleDate.toInt(),
    note,""
    ,""
)
fun Sale.toEntity() = SaleEntity(
    idSale = idSale,
    idProduct= idProduct.toInt(),
    idLocation = idLocation.toInt(),
    quantity = quantity,
    salePrice =salePrice.toInt(),
    saleDate = saleDate.toLong(),
    note = note?:""

)
fun SaleWithDetails.toDomain() = Sale(
    idSale = idSale,
    idProduct = idProduct.toLong(),
    idLocation = idLocation.toLong(),
    quantity = quantity,
    salePrice = salePrice.toDouble(),
    saleDate = saleDate,
    note = note?:"",
    productName,
    locationName
)
