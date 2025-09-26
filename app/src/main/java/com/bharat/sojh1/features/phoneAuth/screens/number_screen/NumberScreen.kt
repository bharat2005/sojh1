package com.bharat.sojh1.features.phoneAuth.screens.number_screen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import com.bharat.sojh1.R
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.features.phoneAuth.PhoneAuthState
import com.bharat.sojh1.features.phoneAuth.PhoneAuthViewModal
import com.bharat.sojh1.features.phoneAuth.screens.number_screen.components.NumberFeildSection
import com.bharat.sojh1.shared.components.AuthButton

@Composable
fun NumberScreen(viewModal: PhoneAuthViewModal, navigateToOtpScreen: () -> Unit, navigateBack : () -> Unit) {
    val context = LocalContext.current
    val authState = viewModal.authState.collectAsState().value
    val phoneNumber = viewModal.phoneNumber.collectAsState().value
    val focusManger = LocalFocusManager.current

    BackHandler {
            viewModal.resetStateForPhoneNumberEntry(true)
            navigateBack()

    }

    LaunchedEffect(authState) {
        if(authState is PhoneAuthState.OtpEntry){
            navigateToOtpScreen()
        }
    }

    Scaffold{
        paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(MaterialTheme.colorScheme.background)
                .clickable(onClick = {
                    focusManger.clearFocus()
                }, indication = null, interactionSource = remember { MutableInteractionSource() }),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            Image(
                    painterResource(R.drawable.sojh),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(60.dp).width(120.dp)
                )


            Spacer(modifier = Modifier.height(24.dp))
            NumberFeildSection(
                value =viewModal.phoneNumber.collectAsState().value,
                onValueChange = {if(it.length <= 10) viewModal.setPhoneNumber(it)},
                isError =  viewModal.authState.collectAsState().value is PhoneAuthState.Error,
                errorText = (authState as? PhoneAuthState.Error)?.message
            )


            Spacer(modifier = Modifier.height(56.dp))
            AuthButton(
                onClick = {
                    (context as? Activity)?.let {
                        viewModal.sendVerificationCode(context)
                    }
                },
                isLoading = authState is PhoneAuthState.Loading,
                enabled = phoneNumber.length == 10 && authState !is PhoneAuthState.Loading,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).width( 160.dp),
                text = "Send OTP",
                clearFocus = {focusManger.clearFocus()}
            )




        }

    }


}