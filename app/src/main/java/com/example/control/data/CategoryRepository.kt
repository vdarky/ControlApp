package com.example.control.data

import com.example.control.data.dao.CategoryDao
import com.example.control.data.entity.CategoryEntity
import com.example.control.domain.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryRepository(
    private val categoryDao: CategoryDao // Nota: Cambié "CategoryDao" a minúscula por buenas prácticas
) {
    suspend fun insertCategory(category: Category){
        categoryDao.insertCategory(category.toEntity())
    }

    suspend fun updateCategory(category: Category){
        categoryDao.updateCategory(category.toEntity())
    }

    suspend fun deleteCategory(category: Category){
        categoryDao.deleteCategory(category.toEntity())
    }

    // CORREGIDO: Ahora el tipo de retorno es Flow<Category?>
    suspend fun getCategoryById(id: Int): Flow<Category?> {
        return categoryDao.getCategoryById(id).map { it?.toDomain() }
    }

    // CORREGIDO: Ahora el tipo de retorno es Flow<List<Category>>
    fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories().map { entities ->
            entities.map { it.toDomain() }
        }
    }
}

// Funciones de extensión (Mappers) - Están perfectas
fun CategoryEntity.toDomain() = Category(idCategory, name, description)

fun Category.toEntity() = CategoryEntity(idCategory, name, description)