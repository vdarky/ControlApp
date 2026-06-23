package com.example.control.data.repository

import com.example.control.data.dao.LocationDao
import com.example.control.data.entity.LocationEntity
import com.example.control.domain.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocationRepository (
    private val locationDao: LocationDao
){
    //Insert
    suspend fun insertLocation(location: Location){
        locationDao.insertLocation(location.toEntity())
    }
    //Update
    suspend fun updateLocation(location: Location){
        locationDao.updateLocation(location.toEntity())
    }
    //Delete
    suspend fun deleteLocation(location: Location){
        locationDao.deleteLocation(location.toEntity())
    }
    //Query
    suspend fun getLocationById(id: Int): Location?{
        return locationDao.getLocationById(id)?.toDomain()
    }
    //Query
    fun getAllLocations(): Flow<List<Location>>{
        return locationDao.getAllLocations().map{
            entities -> entities.map{
                it.toDomain()
            }
        }
    }
}

// Mappers
fun LocationEntity.toDomain() = Location(idLocation, name, description)
fun Location.toEntity() = LocationEntity(idLocation, name, description)
