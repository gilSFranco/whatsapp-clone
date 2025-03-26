package com.fatec.aula_01.validation.phone.model.use_case

import com.fatec.aula_01.validation.ValidationResult
import java.util.regex.Pattern

class ValidatePhone {

    private val phonePattern: Pattern = Pattern.compile("^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$")

    fun execute (phone: String) : ValidationResult {
        if (phone.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "O telefone não pode estar em branco"
            )
        }

        if (!phonePattern.matcher(phone).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "O telefone digitado não é válido. Exemplo: (13) 99712-1223"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}