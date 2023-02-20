package com.example.a.login.data.network.finalLoginResponse

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LogService @Inject constructor(private val loginClient: Client) {
    suspend fun login(user: String, pass: String) = withContext(Dispatchers.IO) {
        val resp = loginClient.login()
        resp.body()?.wasSuccessful ?: false
    }
}
