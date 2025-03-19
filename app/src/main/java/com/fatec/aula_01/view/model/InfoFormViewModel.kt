package com.fatec.aula_01.view.model

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatec.aula_01.model.UserData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class InfoFormViewModel (

) : ViewModel() {
    var state by mutableStateOf(UserData())

    private val validationEventChannel = Channel<ValidationInfoForm>()
    val validationInfoForm = validationEventChannel.receiveAsFlow()

    fun onEvent (event: InfoFormEvent) {
        when (event) {
            is InfoFormEvent.NameChanged -> {
                state = state.copy(
                    name = event.name
                )
            }

            is InfoFormEvent.EmailChanged -> {
                state = state.copy(
                    email = event.email
                )
            }

            is InfoFormEvent.PhoneNumberChanged -> {
                state = state.copy(
                    phoneNumber = event.phoneNumber
                )
            }

            is InfoFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        viewModelScope.launch {
            validationEventChannel.send(ValidationInfoForm.Success)
        }
    }

    sealed class ValidationInfoForm {
        object Success : ValidationInfoForm()
    }
}