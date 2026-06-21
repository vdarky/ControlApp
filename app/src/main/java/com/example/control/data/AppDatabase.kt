package com.example.control.data;

import ProductLocationDao
import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.control.data.dao.CategoryDao
import com.example.control.data.dao.CostHistoryDao
import com.example.control.data.dao.InventoryReviewDao
import com.example.control.data.dao.LocationDao
import com.example.control.data.dao.ProductDao
import com.example.control.data.dao.ReviewDetailDao
import com.example.control.data.dao.SaleDao
import com.example.control.data.dao.UserDao
import com.example.control.data.entity.CategoryEntity
import com.example.control.data.entity.CostHistoryEntity
import com.example.control.data.entity.InventoryReviewEntity
import com.example.control.data.entity.LocationEntity
import com.example.control.data.entity.ProductEntity
import com.example.control.data.entity.ProductLocationEntity
import com.example.control.data.entity.ReviewDetailEntity
import com.example.control.data.entity.SaleEntity
import com.example.control.data.entity.UserEntity


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
    version = 1,
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
