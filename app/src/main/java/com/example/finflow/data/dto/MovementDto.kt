package com.example.finflow.data.dto

data class MovementDto(
    val id: Int = 0,
    val description: String,
    val category: String,
    val date: String,
    val value: String,
    val kind: String
)
