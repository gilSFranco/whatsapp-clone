package com.fatec.aula_01.ui.screen.chat

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fatec.aula_01.model.ChatMessage
import com.fatec.aula_01.model.UserData
import com.fatec.aula_01.ui.component.Chat
import com.fatec.aula_01.ui.component.ChatActions
import com.fatec.aula_01.ui.component.ChatTitle
import com.fatec.aula_01.ui.component.InfoCard
import com.fatec.aula_01.ui.component.InfoForm
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.PRETO
import com.fatec.aula_01.ui.theme.VERDE_ESCURO
import com.fatec.aula_01.view.model.InfoFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    val viewModel = viewModel<InfoFormViewModel>()
    val state = viewModel.state

    var showInfo by remember {
        mutableStateOf(false)
    }

    var showForm = remember {
        mutableStateOf(false)
    }

    var showTitle = remember {
        mutableStateOf(true)
    }

    val chatMessages = remember {
        mutableListOf<ChatMessage>()
    }

    var messageText by remember {
        mutableStateOf("")
    }

    var currentUser by remember {
        mutableIntStateOf(1)
    }

    val isRotate = remember {
        mutableStateOf(false)
    }

    val rotation by animateFloatAsState(
        targetValue = if (isRotate.value) 45F else 0F,
        animationSpec = tween(
            durationMillis = 300
        ),
        label = "rotationAnimation"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    ChatTitle(
                        userName = state.name,
                        showTitle = showTitle.value
                    )
                },
                actions = {
                    ChatActions(
                        onClickInfo = {
                            showInfo = true
                            showTitle.value = false
                        },
                        iconInfo = Icons.Filled.Info,
                        modifierInfo = Modifier
                            .scale(1.2F),
                        onClickForm = {
                            showTitle.value = !showTitle.value
                            showForm.value = !showForm.value
                            isRotate.value = !isRotate.value
                        },
                        iconForm = Icons.Filled.Add,
                        modifierForm = Modifier
                            .rotate(rotation)
                            .scale(1.2F),
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = PRETO,
                    actionIconContentColor = VERDE_ESCURO,
                    containerColor = BRANCO
                )
            )
        },
        content = { innerPadding ->
            if (showInfo) {
                InfoCard(
                    onDismiss = {
                        showInfo = false
                        if (showForm.value) {
                            showTitle.value = false
                        } else {
                            showTitle.value = true
                        }
                    },
                    paddingTop = innerPadding.calculateTopPadding(),
                    paddingBottom = innerPadding.calculateBottomPadding(),
                    userData = UserData(
                        name = state.name,
                        email = state.email,
                        phoneNumber = state.phoneNumber
                    )
                )
            } else {

                if (showForm.value) {
                     InfoForm(
                        paddingTop = innerPadding.calculateTopPadding(),
                        paddingBottom = innerPadding.calculateBottomPadding(),
                        viewModel = viewModel,
                        isRotate = isRotate,
                        showForm = showForm,
                        showTitle = showTitle
                    )
                } else {
                    Chat(
                        chatMessages = chatMessages,
                        messageText = messageText,
                        onMessageChange = {
                            messageText = it
                        },
                        onSendClick = {
                            if (messageText.isNotBlank()) {
                                chatMessages.add(
                                    ChatMessage(
                                        messageText,
                                        isSent = true,
                                        user = currentUser
                                    )
                                )

                                messageText = ""
                                currentUser = if (currentUser == 1) 2 else 1
                            }
                        },
                        innerPadding = innerPadding
                    )
                }

            }
        },
        containerColor = BRANCO
    )
}