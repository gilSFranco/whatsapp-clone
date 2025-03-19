package com.fatec.aula_01.ui.screen.chat

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.fatec.aula_01.model.ChatMessage
import com.fatec.aula_01.ui.component.Chat
import com.fatec.aula_01.ui.component.InfoCard
import com.fatec.aula_01.ui.component.InfoForm
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.PRETO
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen (

) {
    var showInfo by remember {
        mutableStateOf(false)
    }

    val chatMessages = remember {
        mutableListOf<ChatMessage>()
    }

    var messageText by remember {
        mutableStateOf("")
    }

    var currentUser by remember {
        mutableStateOf(1)
    }

    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Text("TopBar")
                },
                actions = {
                    IconButton (
                        onClick = {
                            showInfo = true
                        }
                    ) {
                        Icon(
                            Icons.Filled.Info,
                            contentDescription = ""
                        )
                    }

                    IconButton (
                        onClick = {}
                    ) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = ""
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = PRETO,
                    actionIconContentColor = VERDE_ESCURO
                )
            )
        },
        content = { innerPadding ->
            if (showInfo) {
                InfoCard(
                    onDismiss = {
                        showInfo = false
                    },
                    innerPadding = innerPadding.calculateTopPadding(),
                    infoName = "Gilmar Soares Franco",
                    infoEmail = "gilmarsoaresfranco@gmail.com",
                    infoTelefone = "(XX) X-XXXX-XXXX",
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
    )
}