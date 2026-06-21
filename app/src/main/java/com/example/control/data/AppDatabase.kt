package com.example.control.data;

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [/*podemos poner un arreglo de entidades*/], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun /*Dao() : Dao*/

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context : Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    ""//nombre de la base de datos
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}
