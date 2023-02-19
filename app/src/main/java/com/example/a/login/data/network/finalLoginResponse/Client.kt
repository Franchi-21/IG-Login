package com.example.a.login.data.network.finalLoginResponse

import com.example.a.login.data.network.finalLoginResponse.LogResponse
import retrofit2.Response
import retrofit2.http.GET

interface Client {
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa814")
    suspend fun login(): Response<LogResponse>
}