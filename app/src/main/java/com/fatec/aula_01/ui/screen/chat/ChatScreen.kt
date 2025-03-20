package com.fatec.aula_01.ui.screen.chat

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fatec.aula_01.model.ChatMessage
import com.fatec.aula_01.model.UserData
import com.fatec.aula_01.ui.component.Chat
import com.fatec.aula_01.ui.component.InfoCard
import com.fatec.aula_01.ui.component.InfoForm
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.PRETO
import com.fatec.aula_01.ui.theme.Typography
import com.fatec.aula_01.ui.theme.VERDE_ESCURO
import com.fatec.aula_01.view.model.InfoFormEvent
import com.fatec.aula_01.view.model.InfoFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(

) {
    val viewModel = viewModel<InfoFormViewModel>()
    val state = viewModel.state

    var showInfo by remember {
        mutableStateOf(false)
    }

    var showForm by remember {
        mutableStateOf(false)
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

    var userData by remember {
        mutableStateOf(UserData())
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            modifier = Modifier
                                .scale(1.2F),
                            tint = VERDE_ESCURO
                        )

                        if (!showInfo) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Icon(
                                    Icons.Filled.AccountCircle,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .scale(1.2F)
                                )

                                Text(
                                    "Gilmar",
                                    style = Typography.titleMedium
                                )
                            }
                        }
                    }

                },
                actions = {
                    IconButton(
                        onClick = {
                            showInfo = true
                        }
                    ) {
                        Icon(
                            Icons.Filled.Info,
                            contentDescription = "",
                            modifier = Modifier
                                .scale(1.2F)
                        )
                    }

                    IconButton(
                        onClick = {
                            showForm = !showForm
                            isRotate.value = !isRotate.value
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "",
                            modifier = Modifier
                                .rotate(rotation)
                                .scale(1.2F)
                        )
                    }
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

                if (showForm) {
                    userData = InfoForm(
                        paddingTop = innerPadding.calculateTopPadding(),
                        paddingBottom = innerPadding.calculateBottomPadding(),
                        onClick = {
                            viewModel.onEvent(InfoFormEvent.NameChanged(userData.name))
                            viewModel.onEvent(InfoFormEvent.EmailChanged(userData.email))
                            viewModel.onEvent(InfoFormEvent.PhoneNumberChanged(userData.phoneNumber))

                            showForm = false
                            isRotate.value = !isRotate.value
                        }
                    )
                } else {
                    Chat(
                        chatMessages = chatMessages,
                        messageText = messageText,
                        currentUser = currentUser,
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