package com.fatec.aula_01.validation.email.data

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import com.fatec.aula_01.validation.RegistrationFormState
import com.fatec.aula_01.validation.email.model.EmailViewModel

@Composable
fun validationDataEmail (
    context: Context,
    viewModelEmail: EmailViewModel,
    stateEmail: RegistrationFormState
) : Boolean {
    var emailSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelEmail.validationEventEmail.collect { event ->
            when (event) {
                is EmailViewModel.ValidationEmail.Success -> {
                    emailSuccess = true
                }
            }
        }
    }

    if (stateEmail.emailError != null) {
        emailSuccess = false
    }

    return emailSuccess
}