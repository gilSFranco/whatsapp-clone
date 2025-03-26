package com.fatec.aula_01.validation

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)