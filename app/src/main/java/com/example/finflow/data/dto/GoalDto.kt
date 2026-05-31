package com.example.finflow.data.dto

data class GoalDto(
    val id: Int = 0,
    val name: String,
    val current: String,
    val target: String,
    val dueDate: String,
    val progress: Float
)
