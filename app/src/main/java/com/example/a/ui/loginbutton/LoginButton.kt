package com.example.a.ui.loginbutton

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a.login.LoginViewModel

@Composable
fun LoginButton(isLoginEnabled: Boolean, loginVM: LoginViewModel) {
    Button(
        onClick = { loginVM.onLogin() },
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF42acff),
            disabledBackgroundColor = Color(0xFF71b3fe),
            contentColor = Color.White,
            disabledContentColor = Color.White,
        ),
        enabled = isLoginEnabled,
    ) {
        Text(text = "Log in", color = Color.White)
    }
}
