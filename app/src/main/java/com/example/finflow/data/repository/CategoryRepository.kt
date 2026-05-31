package com.example.finflow.data.repository

import com.example.finflow.data.dto.CategoryDto
import com.example.finflow.data.local.dao.CategoryDao
import com.example.finflow.data.mapper.toDto
import com.example.finflow.data.mapper.toEntity
import com.example.finflow.ui.data.MovementKind
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(
    private val categoryDao: CategoryDao
) {
    suspend fun getAll(): List<CategoryDto> = withContext(Dispatchers.IO) {
        categoryDao.getAll().map { it.toDto() }
    }

    suspend fun getByKind(kind: MovementKind): List<CategoryDto> = withContext(Dispatchers.IO) {
        categoryDao.getByKind(kind.name).map { it.toDto() }
    }

    suspend fun getById(id: Int): CategoryDto? = withContext(Dispatchers.IO) {
        categoryDao.getById(id)?.toDto()
    }

    suspend fun save(category: CategoryDto): Long = withContext(Dispatchers.IO) {
        categoryDao.insert(category.toEntity())
    }

    suspend fun saveAll(categories: List<CategoryDto>) = withContext(Dispatchers.IO) {
        categoryDao.insertAll(categories.map { it.toEntity() })
    }

    suspend fun update(category: CategoryDto) = withContext(Dispatchers.IO) {
        categoryDao.update(category.toEntity())
    }

    suspend fun delete(category: CategoryDto) = withContext(Dispatchers.IO) {
        categoryDao.delete(category.toEntity())
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        categoryDao.deleteAll()
    }
}
