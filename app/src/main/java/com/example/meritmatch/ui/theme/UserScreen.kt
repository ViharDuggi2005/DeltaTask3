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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UserScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome", fontSize = 76.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Karma Points", fontSize = 45.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("login") }) {
            Text(text = "Your Tasks",fontSize = 25.sp)
        }

    }
}
