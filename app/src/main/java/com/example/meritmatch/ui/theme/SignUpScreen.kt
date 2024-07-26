package com.example.meritmatch.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.meritmatch.network.ApiClient
import com.example.meritmatch.network.ApiResponse
import com.example.meritmatch.network.ApiService
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SignUpScreen(navController: NavController) {
    val fullName = remember { mutableStateOf("") }
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
            value = fullName.value,
            onValueChange = { fullName.value = it },
            label = { Text("Full Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
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
        /*Button(onClick = {
            apiService.signup(fullName.value, username.value, password.value).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: retrofit2.Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.body()?.message == "User created successfully") {
                        navController.navigate("user")
                    } else {
                        message = response.body()?.message ?: "Signup failed"
                    }
                }
                override fun onFailure(call: retrofit2.Call<ApiResponse>, t: Throwable) {
                    message = "Signup failed"
                }
            })
        }) {
            Text(text = "Sign Up", fontSize = 25.sp)
        }*/
        /*Button(onClick = {
            println("Attempting signup with fullName: ${fullName.value}, username: ${username.value}, password: ${password.value}")
            apiService.signup(fullName.value, username.value, password.value).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: retrofit2.Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        println("Response successful: ${response.body()}")
                        if (response.body()?.message == "User created successfully") {
                            navController.navigate("user")
                        } else {
                            message = response.body()?.message ?: "Signup failed"
                            println("Signup failed: ${response.body()?.message}")
                        }
                    } else {
                        message = "Signup failed: ${response.errorBody()?.string()}"
                        println("Response error: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: retrofit2.Call<ApiResponse>, t: Throwable) {
                    message = "Signup failed: ${t.message}"
                    println("Signup error: ${t.message}")
                }
            })
        }) {
            Text(text = "Sign Up", fontSize = 25.sp)
        }*/

        /*Button(onClick = {
            apiService.signup(fullName.value, username.value, password.value).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: retrofit2.Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful && response.body()?.message == "User created successfully") {
                        navController.navigate("user")
                    } else {
                        message = response.body()?.message ?: "Signup failed"
                        println("Signup failed: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: retrofit2.Call<ApiResponse>, t: Throwable) {
                    message = "Signup failed"
                    println("Signup error: ${t.message}")
                }
            })
        }) {
            Text(text = "Sign Up", fontSize = 25.sp)
        }

        */
        Button(onClick = {
                    Log.d("SignUpScreen", "Sign Up button clicked")
                    println("Attempting signup with fullName: ${fullName.value}, username: ${username.value}, password: ${password.value}")
                    apiService.signup(fullName.value, username.value, password.value).enqueue(object : Callback<ApiResponse> {
                        override fun onResponse(call: retrofit2.Call<ApiResponse>, response: Response<ApiResponse>) {
                            if (response.isSuccessful) {
                                Log.d("SignUpScreen", "Response successful: ${response.body()}")
                                println("Response successful: ${response.body()}")
                                if (response.body()?.message == "User created successfully") {
                                    navController.navigate("user")
                                } else {
                                    message = response.body()?.message ?: "Signup failed"
                                    Log.d("SignUpScreen", "Signup failed: ${response.body()?.message}")
                                    println("Signup failed: ${response.body()?.message}")
                                }
                            } else {
                                message = "Signup failed: ${response.errorBody()?.string()}"
                                Log.d("SignUpScreen", "Response error: ${response.errorBody()?.string()}")
                                println("Response error: ${response.errorBody()?.string()}")
                            }
                        }

                        override fun onFailure(call: retrofit2.Call<ApiResponse>, t: Throwable) {
                            message = "Signup failed: ${t.message}"
                            Log.d("SignUpScreen", "Signup error: ${t.message}")
                            println("Signup error: ${t.message}")
                        }
                    })
                }) {
                    Text(text = "Sign Up", fontSize = 25.sp)
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

