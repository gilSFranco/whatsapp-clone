package com.fatec.aula_01.validation.phone.data

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.fatec.aula_01.validation.RegistrationFormState
import com.fatec.aula_01.validation.phone.model.PhoneViewModel

@Composable
fun validationDataPhone (
    context: Context,
    viewModelPhone: PhoneViewModel,
    statePhone: RegistrationFormState
) : Boolean {
    var phoneSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelPhone.validationEventPhone.collect { event ->
            when (event) {
                is PhoneViewModel.ValidationPhone.Success -> {
                    phoneSuccess = true
                }
            }
        }
    }

    if (statePhone.phoneError != null) {
        phoneSuccess = false
    }

    return phoneSuccess
}