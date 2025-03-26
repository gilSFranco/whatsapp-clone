package com.fatec.aula_01.validation.email.model

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatec.aula_01.validation.RegistrationFormState
import com.fatec.aula_01.validation.email.model.use_case.ValidateEmail
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class EmailViewModel (
    private val validateEmail: ValidateEmail = ValidateEmail()
) : ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEmail>()
    val validationEventEmail = validationEventChannel.receiveAsFlow()

    fun onEvent (event: EmailFormEvent) {
        when (event) {
            is EmailFormEvent.EmailChanged -> {
                state = state.copy(
                    email = event.email
                )
            }

            is EmailFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)

        if (!emailResult.successful) {
            state = state.copy(
                emailError = emailResult.errorMessage
            )
            return
        }

        state = state.copy(
            emailError = null
        )

        viewModelScope.launch {
            validationEventChannel.send(ValidationEmail.Success)
        }
    }

    sealed class ValidationEmail {
        object Success : ValidationEmail()
    }
}