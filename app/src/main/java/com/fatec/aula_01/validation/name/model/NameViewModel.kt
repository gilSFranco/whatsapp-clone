package com.fatec.aula_01.validation.name.model

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatec.aula_01.validation.RegistrationFormState
import com.fatec.aula_01.validation.name.model.use_case.ValidateName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NameViewModel (
    private val validateName: ValidateName = ValidateName()
) : ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEventName>()
    val validatioEventName = validationEventChannel.receiveAsFlow()

    fun onEvent (event: NameFormEvent) {
        when (event) {
            is NameFormEvent.NameChanged -> {
                state = state.copy(
                    name = event.name
                )
            }

            is NameFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val nameResult = validateName.execute(state.name)

        if (!nameResult.successful) {
            state = state.copy(
                nameError = nameResult.errorMessage
            )
            return
        }

        state = state.copy(
            nameError = null
        )

        viewModelScope.launch {
            validationEventChannel.send(ValidationEventName.Success)
        }
    }

    sealed class ValidationEventName {
        object Success : ValidationEventName()
    }
}