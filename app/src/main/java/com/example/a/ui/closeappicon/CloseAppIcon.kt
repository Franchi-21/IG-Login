package com.example.a.ui.closeappicon

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun CloseAppIcon(modifier: Modifier = Modifier) {
    val context = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "closeApp",
        modifier = modifier.clickable { context.finish() },
    )
}
