package com.fatec.aula_01.validation.name.data

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.fatec.aula_01.validation.RegistrationFormState
import com.fatec.aula_01.validation.name.model.NameViewModel

@Composable
fun validationDataName (
    context: Context,
    viewModelName: NameViewModel,
    stateName: RegistrationFormState
) : Boolean {
    var nameSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelName.validatioEventName.collect { event ->
            when (event) {
                is NameViewModel.ValidationEventName.Success -> {
                    nameSuccess = true
                }
            }
        }
    }

    if (stateName.nameError != null) {
        nameSuccess = false
    }

    return nameSuccess
}