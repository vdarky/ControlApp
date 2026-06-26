package com.example.control.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.control.model.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao{

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertCategory(category: CategoryEntity): Long

    @Update
    suspend fun updateCategory(category: CategoryEntity)

    @Delete
    suspend fun deleteCategory(category: CategoryEntity)

    @Query("SELECT * FROM category WHERE idCategory = :id")
    fun getCategoryById(id: Int): Flow<CategoryEntity?>

    @Query("SELECT * FROM category ORDER BY name ASC")
    fun getAllCategories(): Flow<List<CategoryEntity>>

}