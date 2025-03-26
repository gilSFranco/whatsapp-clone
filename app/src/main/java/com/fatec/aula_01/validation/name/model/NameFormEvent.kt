package com.fatec.aula_01.validation.name.model

sealed class NameFormEvent {
    data class NameChanged(val name: String) : NameFormEvent()

    object Submit : NameFormEvent()
}