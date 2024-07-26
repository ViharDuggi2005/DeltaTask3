package com.example.meritmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.meritmatch.ui.theme.MeritMatchTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meritmatch.ui.theme.HomeScreen
import com.example.meritmatch.ui.theme.LoginScreen
import com.example.meritmatch.ui.theme.SignUpScreen
import com.example.meritmatch.ui.theme.UserScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeritMatchTheme {Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            )
            {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("login") { LoginScreen(navController) }
                    composable("signup") { SignUpScreen(navController) }
                    composable("user") { UserScreen(navController) }
                }
            }
        }
    }
}}
