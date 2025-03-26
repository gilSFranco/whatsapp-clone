package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.validation.email.data.validationDataEmail
import com.fatec.aula_01.validation.email.model.EmailFormEvent
import com.fatec.aula_01.validation.email.model.EmailViewModel
import com.fatec.aula_01.validation.name.data.validationDataName
import com.fatec.aula_01.validation.name.model.NameFormEvent
import com.fatec.aula_01.validation.name.model.NameViewModel
import com.fatec.aula_01.validation.phone.data.validationDataPhone
import com.fatec.aula_01.validation.phone.model.PhoneFormEvent
import com.fatec.aula_01.validation.phone.model.PhoneViewModel
import com.fatec.aula_01.view.model.InfoFormEvent
import com.fatec.aula_01.view.model.InfoFormViewModel

@Composable
fun InfoForm(
    paddingTop: Dp,
    paddingBottom: Dp,
    viewModel: InfoFormViewModel,
    isRotate: MutableState<Boolean>,
    showForm: MutableState<Boolean>,
    showTitle: MutableState<Boolean>
) {
    val context = LocalContext.current

    val viewModelName = viewModel<NameViewModel>()
    val stateName = viewModelName.state

    val viewModelEmail = viewModel<EmailViewModel>()
    val stateEmail = viewModelEmail.state

    val viewModelPhone = viewModel<PhoneViewModel>()
    val statePhone = viewModelPhone.state

    val validationDataName = validationDataName(
        context = context,
        viewModelName = viewModelName,
        stateName = stateName
    )

    val validationDataEmail = validationDataEmail(
        context = context,
        viewModelEmail = viewModelEmail,
        stateEmail = stateEmail
    )

    val validationDataPhone = validationDataPhone(
        context = context,
        viewModelPhone = viewModelPhone,
        statePhone = statePhone
    )

    val isValidationSuccessful = validationDataName && validationDataEmail && validationDataPhone

    Column(
        modifier = Modifier
            .padding(
                top = paddingTop,
                bottom = paddingBottom,
                start = 20.dp,
                end = 20.dp
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(
                space = 10.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ChatIcon(
                icon = Icons.Filled.AccountCircle,
                modifier = Modifier
                    .size(80.dp)
            )

            Text(
                text = "Cadastro do Usuário",
                style = Typography.titleLarge
            )

            Text(
                "Forneça seu nome, email e telefone para cadastro.",
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ChatTextBox(
                containsLabel = true,
                value = stateName.name,
                onValueChange = {
                    viewModelName.onEvent(NameFormEvent.NameChanged(it))
                    viewModelName.onEvent(NameFormEvent.Submit)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = "Nome",
                placeholder = "Digite seu nome",
                isError = stateName.nameError != null,
                errorState = stateName.nameError,
                keyboardType = KeyboardType.Text
            )

            Spacer(modifier = Modifier.height(20.dp))

            ChatTextBox(
                containsLabel = true,
                value = stateEmail.email,
                onValueChange = {
                    viewModelEmail.onEvent(EmailFormEvent.EmailChanged(it))
                    viewModelEmail.onEvent(EmailFormEvent.Submit)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = "Email",
                placeholder = "Digite seu email",
                isError = stateEmail.emailError != null,
                errorState = stateEmail.emailError,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(20.dp))

            ChatTextBox(
                containsLabel = true,
                value = statePhone.phone,
                onValueChange = {
                    viewModelPhone.onEvent(PhoneFormEvent.PhoneChanged(it))
                    viewModelPhone.onEvent(PhoneFormEvent.Submit)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = "Telefone",
                placeholder = "Digite seu telefone",
                isError = statePhone.phoneError != null,
                errorState = statePhone.phoneError,
                keyboardType = KeyboardType.Phone,
                lastOne = true
            )
        }

        Spacer(
            modifier = Modifier
                .weight(1F)
        )

        InfoButton(
            onClick = {
                viewModelName.onEvent(NameFormEvent.Submit)
                viewModelEmail.onEvent(EmailFormEvent.Submit)
                viewModelPhone.onEvent(PhoneFormEvent.Submit)

                if (isValidationSuccessful) {
                    viewModel.onEvent(InfoFormEvent.NameChanged(stateName.name))
                    viewModel.onEvent(InfoFormEvent.EmailChanged(stateEmail.email))
                    viewModel.onEvent(InfoFormEvent.PhoneNumberChanged(statePhone.phone))

                    showForm.value = false
                    showTitle.value = true
                    isRotate.value = !isRotate.value
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            text = "Cadastrar"
        )
    }
}