package com.fatec.aula_01.validation.email.model

sealed class EmailFormEvent {
    data class EmailChanged(val email: String) : EmailFormEvent()

    object Submit : EmailFormEvent()
}