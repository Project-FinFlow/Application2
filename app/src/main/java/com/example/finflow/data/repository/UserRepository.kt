package com.example.finflow.data.repository

import com.example.finflow.data.dto.UserDto
import com.example.finflow.data.local.dao.UserDao
import com.example.finflow.data.mapper.toDto
import com.example.finflow.data.mapper.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(
    private val userDao: UserDao
) {
    suspend fun getAll(): List<UserDto> = withContext(Dispatchers.IO) {
        userDao.getAll().map { it.toDto() }
    }

    suspend fun getByEmail(email: String): UserDto? = withContext(Dispatchers.IO) {
        userDao.getByEmail(email)?.toDto()
    }

    suspend fun save(user: UserDto) = withContext(Dispatchers.IO) {
        userDao.insert(user.toEntity())
    }

    suspend fun saveAll(users: List<UserDto>) = withContext(Dispatchers.IO) {
        userDao.insertAll(users.map { it.toEntity() })
    }

    suspend fun update(user: UserDto) = withContext(Dispatchers.IO) {
        userDao.update(user.toEntity())
    }

    suspend fun delete(user: UserDto) = withContext(Dispatchers.IO) {
        userDao.delete(user.toEntity())
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        userDao.deleteAll()
    }
}
