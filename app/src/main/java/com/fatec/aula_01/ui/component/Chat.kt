package com.fatec.aula_01.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.model.ChatMessage
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.VERDE_ESCURO

@Composable
fun Chat(
    chatMessages: MutableList<ChatMessage>,
    messageText: String,
    onMessageChange: (String) -> Unit,
    onSendClick: () -> Unit,
    innerPadding: PaddingValues
) {
    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            8.dp
        )
    ) {
        LazyColumn (
            modifier = Modifier
                .weight(1f)
        ) {
            items(
                chatMessages
            ) {
                message -> ChatMessageItem(message)
            }
        }

        Row (
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ChatTextBox(
                value = messageText,
                onValueChange = onMessageChange,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1F),
                placeholder = "Digite sua mensagem"
            )

            FloatingActionButton(
                onClick = onSendClick,
                containerColor = VERDE_ESCURO,
                modifier = Modifier
                    .padding(start = 8.dp),
                contentColor = BRANCO
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = ""
                )
            }
        }
    }
}