package com.example.control.model;

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.control.model.dao.CategoryDao
import com.example.control.model.dao.CostHistoryDao
import com.example.control.model.dao.InventoryReviewDao
import com.example.control.model.dao.LocationDao
import com.example.control.model.dao.ProductDao
import com.example.control.model.dao.ProductLocationDao
import com.example.control.model.dao.ReviewDetailDao
import com.example.control.model.dao.SaleDao
import com.example.control.model.dao.UserDao
import com.example.control.model.entity.CategoryEntity
import com.example.control.model.entity.CostHistoryEntity
import com.example.control.model.entity.InventoryReviewEntity
import com.example.control.model.entity.LocationEntity
import com.example.control.model.entity.ProductEntity
import com.example.control.model.entity.ProductLocationEntity
import com.example.control.model.entity.ReviewDetailEntity
import com.example.control.model.entity.SaleEntity
import com.example.control.model.entity.UserEntity


@Database(entities = [
    CategoryEntity :: class,
    CostHistoryEntity :: class,
    InventoryReviewEntity :: class,
    LocationEntity :: class,
    ProductEntity :: class,
    ProductLocationEntity :: class,
    ReviewDetailEntity :: class,
    SaleEntity:: class,
    UserEntity :: class],
    version = 2,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun CategoryDao() : CategoryDao
    abstract fun CostHistoryDao() : CostHistoryDao
    abstract fun InventoryReviewDao() : InventoryReviewDao
    abstract fun LocationDao() : LocationDao
    abstract fun ProductDao() : ProductDao
    abstract fun ProductLocationDao() : ProductLocationDao
    abstract fun ReviewDetailDao() : ReviewDetailDao
    abstract fun SaleDao() : SaleDao
    abstract fun UserDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context : Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ControlDB"//nombre de la base de datos
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}
