package com.example.a.ui.forgotpassword

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ForgotPassword(modifier: Modifier = Modifier) {
    Text(
        text = "Forgot password?",
        color = Color(red = 0, green = 113, blue = 188),
        modifier = modifier,
        fontWeight = FontWeight.Bold,
    )
}
