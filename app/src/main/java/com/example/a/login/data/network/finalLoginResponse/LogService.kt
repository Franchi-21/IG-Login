package com.example.a.login.data.network.finalLoginResponse

import com.example.a.core.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LogService {
    private val retroInstance = RetrofitInstance.getInstance()

    suspend fun login(user: String, pass: String) = withContext(Dispatchers.IO) {
        val resp = retroInstance
            ?.create(Client::class.java)
            ?.login()
        resp?.body()?.wasSuccessful ?: false
    }
}
