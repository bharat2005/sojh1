package com.bharat.sojh1.features.phoneAuth.screens.otp_screen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.features.phoneAuth.PhoneAuthState
import com.bharat.sojh1.features.phoneAuth.PhoneAuthViewModal
import com.bharat.sojh1.features.phoneAuth.screens.otp_screen.components.OtpTextSection
import com.bharat.sojh1.shared.components.AuthButton
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(viewModal: PhoneAuthViewModal, navigateBack : () -> Unit) {
    val authState = viewModal.authState.collectAsState().value
    val verificationSuccess = remember { mutableStateOf(false) }
    val otpCode = viewModal.otpCode.collectAsState().value
    val canResend  = viewModal.canResend.collectAsState().value
    val context = LocalContext.current
    val timer = viewModal.timer.collectAsState().value
    val focusManger = LocalFocusManager.current
    val errorText = (authState as? PhoneAuthState.Error)?.message






    BackHandler {
        if(viewModal.authState.value !is PhoneAuthState.Success){
            viewModal.resetStateForPhoneNumberEntry()
            navigateBack()
        }
    }

    LaunchedEffect(Unit) {
        if(authState is PhoneAuthState.OtpEntry){
            viewModal.startTimer()
        }
    }



    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        viewModal.resetStateForPhoneNumberEntry()
                        navigateBack()}
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back" )
                    }
                },
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(MaterialTheme.colorScheme.background)
                .clickable(onClick = {
                    focusManger.clearFocus()
                }, indication = null, interactionSource = remember { MutableInteractionSource() }),
        ) {

            OtpTextSection(modifier = Modifier.weight(1f), viewModel = viewModal, authState = authState)



            if(errorText != null){
                Text(
                    errorText,
                    color= MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 12.dp)
                )
            }



            Spacer(modifier = Modifier.height(26.dp))
            TextButton(
                onClick = {
                    (context as? Activity)?.let {
                        viewModal.resendVerificationCode(context)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                enabled = canResend
            ) {
                Text(
                    text = if (canResend) "Resend OTP" else  "Resend OTP in 00:${timer}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (canResend) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            }


            Spacer(modifier = Modifier.height(80.dp))
            AuthButton(
                onClick = {
                    viewModal.verifyOtp()
                },
                enabled = otpCode.length == 6 && authState !is PhoneAuthState.Loading,
                isLoading = authState is PhoneAuthState.Loading,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).width( 180.dp),
                text = "Continue",
                clearFocus = {focusManger.clearFocus()}

            )



        }
    }





}
