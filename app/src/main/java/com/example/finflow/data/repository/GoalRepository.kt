package com.example.finflow.data.repository

import com.example.finflow.data.dto.GoalDto
import com.example.finflow.data.local.dao.GoalDao
import com.example.finflow.data.mapper.toDto
import com.example.finflow.data.mapper.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GoalRepository(
    private val goalDao: GoalDao
) {
    suspend fun getAll(): List<GoalDto> = withContext(Dispatchers.IO) {
        goalDao.getAll().map { it.toDto() }
    }

    suspend fun getById(id: Int): GoalDto? = withContext(Dispatchers.IO) {
        goalDao.getById(id)?.toDto()
    }

    suspend fun save(goal: GoalDto): Long = withContext(Dispatchers.IO) {
        goalDao.insert(goal.toEntity())
    }

    suspend fun saveAll(goals: List<GoalDto>) = withContext(Dispatchers.IO) {
        goalDao.insertAll(goals.map { it.toEntity() })
    }

    suspend fun update(goal: GoalDto) = withContext(Dispatchers.IO) {
        goalDao.update(goal.toEntity())
    }

    suspend fun delete(goal: GoalDto) = withContext(Dispatchers.IO) {
        goalDao.delete(goal.toEntity())
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        goalDao.deleteAll()
    }
}
