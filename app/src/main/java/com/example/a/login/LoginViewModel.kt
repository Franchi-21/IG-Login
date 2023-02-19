package com.example.a.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String> = _pass
    private val _isLoginCorrect = MutableLiveData<Boolean>()
    val isLoginCorrect: LiveData<Boolean> = _isLoginCorrect

    fun onLoginChange(email: String, pass: String) {
        _email.value = email
        _pass.value = pass
        _isLoginCorrect.value = checkPassAndEmail(pass = pass, email = email)
    }

    private fun checkPassAndEmail(pass: String, email: String) =
        pass.length > 12 && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}