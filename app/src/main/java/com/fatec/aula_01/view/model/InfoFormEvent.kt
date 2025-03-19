package com.fatec.aula_01.view.model

sealed class InfoFormEvent {
    data class NameChanged(val name: String) : InfoFormEvent()
    data class EmailChanged(val email: String) : InfoFormEvent()
    data class PhoneNumberChanged(val phoneNumber: String) : InfoFormEvent()

    object Submit : InfoFormEvent()
}