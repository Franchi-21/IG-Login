package com.example.a.ui.loginandlogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.a.login.LoginViewModel
import com.example.a.ui.emailprompt.EmailPrompt
import com.example.a.ui.forgotpassword.ForgotPassword
import com.example.a.ui.iglogo.Logo
import com.example.a.ui.loginbutton.LoginButton
import com.example.a.ui.loginfacebook.LoginFacebook
import com.example.a.ui.passprompt.PassPrompt
import com.example.a.ui.signupfooter.spacerlogin.SpacerLogin

@Composable
fun LoginAndLogo(modifier: Modifier = Modifier, loginVM: LoginViewModel) {
    val email by loginVM.email.observeAsState(initial = "")
    val pass by loginVM.pass.observeAsState(initial = "")
    val isLoginEnabled by loginVM.isLoginCorrect.observeAsState(initial = false)
    Column(modifier = modifier) {
        Logo(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.size(20.dp))
        EmailPrompt(email = email) {
            loginVM.onLoginChange(email = it, pass = pass)
        }
        Spacer(Modifier.size(6.dp))
        PassPrompt(pass = pass) {
            loginVM.onLoginChange(email = email, pass = it)
        }
        Spacer(Modifier.size(15.dp))
        ForgotPassword(modifier = Modifier.align(Alignment.End))
        Spacer(Modifier.size(20.dp))
        LoginButton(isLoginEnabled = isLoginEnabled, loginVM = loginVM)
        Spacer(Modifier.size(30.dp))
        SpacerLogin()
        Spacer(Modifier.size(30.dp))
        LoginFacebook()
    }
}
