package com.example.finflow.data.dto

data class LogDto(
    val id: Int = 0,
    val event: String,
    val actor: String,
    val date: String,
    val status: String
)
