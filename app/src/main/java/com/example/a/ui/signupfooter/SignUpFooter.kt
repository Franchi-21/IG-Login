package com.example.a.ui.signupfooter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a.ui.signup.SignUp

@Composable
fun SignupFooter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            color = Color(0xFFD7D7D7),
            modifier = Modifier.height(1.dp),
        )
        Spacer(Modifier.size(25.dp))
        SignUp()
        Spacer(Modifier.size(25.dp))
    }
}