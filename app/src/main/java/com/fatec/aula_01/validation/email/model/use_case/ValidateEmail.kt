package com.fatec.aula_01.validation.email.model.use_case

import android.util.Patterns
import com.fatec.aula_01.validation.ValidationResult

class ValidateEmail {

    fun execute (email: String) : ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "O email não pode estar em branco"
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "O email digitado não é válido"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}