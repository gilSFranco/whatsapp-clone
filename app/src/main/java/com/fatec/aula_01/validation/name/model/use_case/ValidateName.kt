package com.fatec.aula_01.validation.name.model.use_case

import com.fatec.aula_01.validation.ValidationResult

class ValidateName {

    fun execute (name: String) : ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "O nome não pode estar em branco"
            )
        }

        if (name.length < 2) {
            return ValidationResult(
                successful = false,
                errorMessage = "O nome precisa ter pelo menos 2 caracteres"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}