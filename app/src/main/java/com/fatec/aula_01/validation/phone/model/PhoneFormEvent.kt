package com.fatec.aula_01.validation.phone.model

sealed class PhoneFormEvent {
    data class PhoneChanged(val phone: String) : PhoneFormEvent()

    object Submit : PhoneFormEvent()
}