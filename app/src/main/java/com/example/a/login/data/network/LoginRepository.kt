package com.example.a.login.data.network

import com.example.a.login.data.network.finalLoginResponse.LogService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LogService) {
    suspend fun onLogin(pass: String, user: String) =
        api.login(pass = pass, user = user)
}
