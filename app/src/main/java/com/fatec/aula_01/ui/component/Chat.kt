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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.fatec.aula_01.model.ChatMessage
import com.fatec.aula_01.ui.theme.BRANCO
import com.fatec.aula_01.ui.theme.VERDE_ESCURO
import kotlinx.coroutines.launch

@Composable
fun Chat(
    chatMessages: MutableList<ChatMessage>,
    messageText: String,
    onMessageChange: (String) -> Unit,
    onSendClick: () -> Unit,
    innerPadding: PaddingValues
) {
    val listState = rememberLazyListState()

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
                .weight(1f),
            state = listState
        ) {
            items(
                chatMessages
            ) {
                message -> ChatMessageItem(message)
            }
        }

        ScrollToTopButton(
            state = listState
        )

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
                placeholder = "Digite sua mensagem",
                keyboardType = KeyboardType.Text,
                lastOne = true
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