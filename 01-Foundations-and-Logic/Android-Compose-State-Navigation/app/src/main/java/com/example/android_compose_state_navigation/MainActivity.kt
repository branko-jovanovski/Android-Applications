package com.example.android_compose_state_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.android_compose_state_navigation.navigation.StudentNavHost
import com.example.android_compose_state_navigation.ui.theme.AndroidComposeStateNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeStateNavigationTheme {
                StudentNavHost()
            }
        }
    }
}
