package com.example.meritmatch.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    //val custom= FontFamily(Font(R.font.bubblegum_sans))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFFEB3B), Color(0xFFE2DEBF))
                )
            )
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Merit Match", fontSize = 76.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("login") }) {
            Text(text = "Login",fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("signup") }) {
            Text(text = "Sign Up",fontSize = 25.sp)
        }
    }
}
