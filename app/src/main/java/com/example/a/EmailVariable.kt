package com.example.a

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

data class VariableForPrompt(var name: String, var onChange: (String) -> Unit)

@Composable
fun createVariable(): VariableForPrompt {
    var noName by remember { mutableStateOf("") }
    return VariableForPrompt(
        name = noName,
        onChange = { noName = it }
    )
}
