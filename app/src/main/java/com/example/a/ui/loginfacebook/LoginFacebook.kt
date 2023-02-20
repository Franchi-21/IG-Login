package com.example.a.ui.loginfacebook

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.a.R

@Composable
fun LoginFacebook() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "fbLogo",
            modifier = Modifier.size(25.dp),
        )
        Text(
            text = "Continue as Dave Johnson",
            color = Color(0xFF42acff),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 6.dp),
        )
    }
}