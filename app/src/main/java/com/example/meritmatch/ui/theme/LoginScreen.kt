package com.example.meritmatch.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.meritmatch.network.ApiClient
import com.example.meritmatch.network.ApiResponse
import com.example.meritmatch.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val apiService = ApiClient.retrofit.create(ApiService::class.java)
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Username") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            apiService.login(username.value, password.value).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.body()?.user != null) {
                        navController.navigate("user")
                    } else {
                        message = "Invalid credentials"
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    message = "Login failed"
                }
            })
        }) {
            Text(text = "Login", fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Home", fontSize = 25.sp)
        }
        if (message.isNotEmpty()) {
            Text(text = message, color = androidx.compose.ui.graphics.Color.Red, fontSize = 20.sp)
        }
    }
}
