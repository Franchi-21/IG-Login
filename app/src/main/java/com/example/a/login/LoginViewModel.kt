package com.example.a.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String> = _pass
    private val _isLoginCorrect = MutableLiveData<Boolean>()
    val isLoginCorrect: LiveData<Boolean> = _isLoginCorrect
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChange(email: String, pass: String) {
        _email.value = email
        _pass.value = pass
        _isLoginCorrect.value = checkPassAndEmail(pass = pass, email = email)
    }

    private fun checkPassAndEmail(pass: String, email: String) =
        pass.length > 12 && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun onLogin() {
        viewModelScope.launch {
            _isLoading.value = true
            if (loginUseCase(_pass.value!!, _email.value!!)) {
                Log.i("test", "correct")
            }
            _isLoading.value = false
        }
    }
}
