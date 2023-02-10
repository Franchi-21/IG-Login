package com.example.a

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Layout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {
        CloseAppIcon(modifier = Modifier.align(Alignment.TopEnd))
        LoginAndLogo(modifier = Modifier.align(Alignment.Center))
        SignupFooter(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun SignupFooter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            color = Color(0xFFD7D7D7),
            modifier = Modifier.height(1.dp)
        )
        Spacer(Modifier.size(25.dp))
        SignUp()
        Spacer(Modifier.size(25.dp))
    }
}

@Composable
fun SignUp() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Don't have an account?", color = Color(0xFFD3D3D3))
        Text(
            text = "Sign up",
            modifier = Modifier
                .clickable { /* TODO */ }
                .padding(5.dp),
            color = Color(0xFF42acff)
        )
    }
}

@Composable
fun LoginAndLogo(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var pass by rememberSaveable { mutableStateOf("") }
    var isLoginEnabled by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        Logo(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.size(20.dp))
        EmailPrompt(email = email) {
            email = it
            isLoginEnabled = checkPassAndEmail(pass = pass, email = email)
        }
        Spacer(Modifier.size(6.dp))
        PassPrompt(pass = pass) {
            pass = it
            isLoginEnabled = checkPassAndEmail(pass = pass, email = email)
        }
        Spacer(Modifier.size(15.dp))
        ForgotPassword(modifier = Modifier.align(Alignment.End))
        Spacer(Modifier.size(20.dp))
        LoginButton(isLoginEnabled = isLoginEnabled)
        Spacer(Modifier.size(30.dp))
        SpacerLogin()
        Spacer(Modifier.size(30.dp))
        LoginFacebook()
    }
}

fun checkPassAndEmail(pass: String, email: String) =
    pass.length > 12 && Patterns.EMAIL_ADDRESS.matcher(email).matches()

@Composable
fun LoginFacebook() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "fbLogo",
            modifier = Modifier.size(25.dp)
        )
        Text(
            text = "Continue as Dave Johnson",
            color = Color(0xFF42acff),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 6.dp)
        )
    }
}

@Composable
fun SpacerLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = Color(0xFFD7D7D7),
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 25.dp),
            color = Color(0xFFB5B5B5)
        )
        Divider(
            color = Color(0xFFD7D7D7),
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(isLoginEnabled: Boolean) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF42acff),
            disabledBackgroundColor = Color(0xFF71b3fe),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        enabled = isLoginEnabled
    ) {
        Text(text = "Log in", color = Color.White)
    }
}

@Composable
fun ForgotPassword(modifier: Modifier = Modifier) {
    Text(
        text = "Forgot password?",
        color = Color(red = 0, green = 113, blue = 188),
        modifier = modifier,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun PassPrompt(pass: String, onValueChange: (String) -> Unit) {
    var showPass by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = pass,
        visualTransformation = if (showPass) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        onValueChange = { onValueChange(it) },
        placeholder = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(0xFFedeeee),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        trailingIcon = {
            val showPassIcon = if (showPass) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { showPass = !showPass }) {
                Icon(
                    imageVector = showPassIcon,
                    contentDescription = "showPass"
                )
            }
        }
    )
}

@Composable
fun EmailPrompt(email: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = { onValueChange(it) },
        placeholder = { Text(text = "Phone number, username or email") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(0xFFedeeee),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        )
    )
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "igLogo",
        modifier = modifier
    )
}

@Composable
private fun CloseAppIcon(modifier: Modifier = Modifier) {
    val context = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "closeApp",
        modifier = modifier.clickable { context.finish() }
    )
}
