package com.example.a.ui.signupfooter.spacerlogin

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpacerLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Divider(
            color = Color(0xFFD7D7D7),
            modifier = Modifier
                .height(1.dp)
                .weight(1f),
        )
        Text(
            text = "OR",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 25.dp),
            color = Color(0xFFB5B5B5),
        )
        Divider(
            color = Color(0xFFD7D7D7),
            modifier = Modifier
                .height(1.dp)
                .weight(1f),
        )
    }
}
