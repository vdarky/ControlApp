package com.example.control.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.control.data.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Insert
    suspend fun insertLocation (location: LocationEntity): Long

    @Update
    suspend fun updateLocation(location: LocationEntity)

    @Delete
    suspend fun deleteLocation(location: LocationEntity)

    @Query("SELECT * FROM location WHERE idLocation = :id")
    suspend fun getLocationById(id: Int): LocationEntity?

    @Query("SELECT * FROM location ORDER BY name ASC")
    fun getAllLocations(): Flow<List<LocationEntity>>
}