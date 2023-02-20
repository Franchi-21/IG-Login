package com.example.a.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.a.login.LoginViewModel
import com.example.a.ui.closeappicon.CloseAppIcon
import com.example.a.ui.loginandlogo.LoginAndLogo
import com.example.a.ui.signupfooter.SignupFooter

@Composable
fun Layout(loginVM: LoginViewModel) {
    val isLoading by loginVM.isLoading.observeAsState(initial = false)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
    ) {
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else {
            CloseAppIcon(modifier = Modifier.align(Alignment.TopEnd))
            LoginAndLogo(modifier = Modifier.align(Alignment.Center), loginVM = loginVM)
            SignupFooter(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}
