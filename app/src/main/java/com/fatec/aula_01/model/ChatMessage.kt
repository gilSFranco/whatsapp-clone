package com.fatec.aula_01.model

data class ChatMessage(
    val text: String,
    val isSent: Boolean,
    val user: Int = 1
)