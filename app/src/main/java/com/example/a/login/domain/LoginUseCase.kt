package com.example.a.login.domain

import com.example.a.login.data.network.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repo: LoginRepository) {
    suspend operator fun invoke(pass: String, user: String) =
        repo.onLogin(user = user, pass = pass)
}
