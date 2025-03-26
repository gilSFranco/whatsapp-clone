package com.fatec.aula_01.validation.phone.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatec.aula_01.validation.RegistrationFormState
import com.fatec.aula_01.validation.phone.model.use_case.ValidatePhone
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PhoneViewModel (
    private val validatePhone: ValidatePhone = ValidatePhone()
) : ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationPhone>()
    val validationEventPhone = validationEventChannel.receiveAsFlow()

    fun onEvent (event: PhoneFormEvent) {
        when (event) {
            is PhoneFormEvent.PhoneChanged -> {
                state = state.copy(
                    phone = event.phone
                )
            }

            is PhoneFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val phoneResult = validatePhone.execute(state.phone)

        if (!phoneResult.successful) {
            state = state.copy(
                phoneError = phoneResult.errorMessage
            )
            return
        }

        state = state.copy(
            phoneError = null
        )

        viewModelScope.launch {
            validationEventChannel.send(ValidationPhone.Success)
        }
    }

    sealed class ValidationPhone {
        object Success : ValidationPhone()
    }
}