package com.example.control.data.repository

import com.example.control.data.dao.UserDao
import com.example.control.data.entity.UserEntity
import com.example.control.domain.User


class UserRepository (
    private val userDao: UserDao
){
    //Insert
    suspend fun insert(idUser: User){
        userDao.insert(idUser.toEntity())
    }
    //Update
    suspend fun update(idUser: User){
        userDao.update(idUser.toEntity())
    }
    //Query
    suspend fun getUser():User?{
        return userDao.getUser()?.toDomain()
    }

}
//Mappers
fun UserEntity.toDomain() = User(idUser, name, pinHash)
fun User.toEntity() = UserEntity(idUser, name, pinHash)
