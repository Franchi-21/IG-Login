package com.example.a.data.network

import com.example.a.data.network.finalLoginResponse.LogService

class LoginRepository {
    private val api = LogService()

    suspend fun onLogin(pass: String, user: String) = api.login(pass = pass, user = user)
}
