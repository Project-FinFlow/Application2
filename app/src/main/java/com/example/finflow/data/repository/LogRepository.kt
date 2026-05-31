package com.example.finflow.data.repository

import com.example.finflow.data.dto.LogDto
import com.example.finflow.data.local.dao.LogDao
import com.example.finflow.data.mapper.toDto
import com.example.finflow.data.mapper.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LogRepository(
    private val logDao: LogDao
) {
    suspend fun getAll(): List<LogDto> = withContext(Dispatchers.IO) {
        logDao.getAll().map { it.toDto() }
    }

    suspend fun getByStatus(status: String): List<LogDto> = withContext(Dispatchers.IO) {
        logDao.getByStatus(status).map { it.toDto() }
    }

    suspend fun getById(id: Int): LogDto? = withContext(Dispatchers.IO) {
        logDao.getById(id)?.toDto()
    }

    suspend fun save(log: LogDto): Long = withContext(Dispatchers.IO) {
        logDao.insert(log.toEntity())
    }

    suspend fun saveAll(logs: List<LogDto>) = withContext(Dispatchers.IO) {
        logDao.insertAll(logs.map { it.toEntity() })
    }

    suspend fun update(log: LogDto) = withContext(Dispatchers.IO) {
        logDao.update(log.toEntity())
    }

    suspend fun delete(log: LogDto) = withContext(Dispatchers.IO) {
        logDao.delete(log.toEntity())
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        logDao.deleteAll()
    }
}
