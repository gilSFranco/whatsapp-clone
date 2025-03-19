package com.fatec.aula_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.fatec.aula_01.ui.screen.chat.ChatScreen
import com.fatec.aula_01.ui.theme.Aula01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula01Theme {
                ChatScreen()
            }
        }
    }
}