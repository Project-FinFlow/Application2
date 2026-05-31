package com.example.finflow.data.repository

import com.example.finflow.data.local.AppDatabase

class FinFlowRepositories(
    database: AppDatabase
) {
    val movements = MovementRepository(database.movementDao())
    val categories = CategoryRepository(database.categoryDao())
    val goals = GoalRepository(database.goalDao())
    val users = UserRepository(database.userDao())
    val logs = LogRepository(database.logDao())
}
