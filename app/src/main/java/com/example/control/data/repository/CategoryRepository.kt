package com.example.control.data.repository

import com.example.control.data.dao.CategoryDao
import com.example.control.data.entity.CategoryEntity
import com.example.control.domain.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryRepository(
    private val categoryDao: CategoryDao
) {
    //Insert
    suspend fun insertCategory(category: Category){
        categoryDao.insertCategory(category.toEntity())
    }
    //Update
    suspend fun updateCategory(category: Category){
        categoryDao.updateCategory(category.toEntity())
    }
    //Delete
    suspend fun deleteCategory(category: Category){
        categoryDao.deleteCategory(category.toEntity())
    }
    //Query
    fun getCategoryById(id: Int): Flow<Category?> {
        return categoryDao.getCategoryById(id).map {
            it?.toDomain()
        }
    }
    //Query
    fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories().map {
            entities -> entities.map {
                it.toDomain() }
        }
    }
}

//Mappers
fun CategoryEntity.toDomain() = Category(idCategory, name, description)

fun Category.toEntity() = CategoryEntity(idCategory, name, description)
