package com.example.finflow.data.repository

import com.example.finflow.data.dto.MovementDto
import com.example.finflow.data.local.dao.MovementDao
import com.example.finflow.data.mapper.toDto
import com.example.finflow.data.mapper.toEntity
import com.example.finflow.ui.data.MovementKind
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovementRepository(
    private val movementDao: MovementDao
) {
    suspend fun getAll(): List<MovementDto> = withContext(Dispatchers.IO) {
        movementDao.getAll().map { it.toDto() }
    }

    suspend fun getDespesas(): List<MovementDto> = getByKind(MovementKind.Despesa)

    suspend fun getReceitas(): List<MovementDto> = getByKind(MovementKind.Receita)

    suspend fun getById(id: Int): MovementDto? = withContext(Dispatchers.IO) {
        movementDao.getById(id)?.toDto()
    }

    suspend fun save(movement: MovementDto): Long = withContext(Dispatchers.IO) {
        movementDao.insert(movement.toEntity())
    }

    suspend fun saveAll(movements: List<MovementDto>) = withContext(Dispatchers.IO) {
        movementDao.insertAll(movements.map { it.toEntity() })
    }

    suspend fun update(movement: MovementDto) = withContext(Dispatchers.IO) {
        movementDao.update(movement.toEntity())
    }

    suspend fun delete(movement: MovementDto) = withContext(Dispatchers.IO) {
        movementDao.delete(movement.toEntity())
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        movementDao.deleteAll()
    }

    private suspend fun getByKind(kind: MovementKind): List<MovementDto> = withContext(Dispatchers.IO) {
        movementDao.getByKind(kind.name).map { it.toDto() }
    }
}
