package com.bharat.sojh1.features.phoneAuth.screens.otp_screen.components

import android.app.Activity
import androidx.activity.result.ActivityResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.bharat.sojh1.features.phoneAuth.PhoneAuthState
import com.bharat.sojh1.features.phoneAuth.PhoneAuthViewModal
import com.bharat.sojh1.shared.components.AuthButton

@Composable
fun OtpTextSection(modifier: Modifier = Modifier, viewModel: PhoneAuthViewModal, authState : PhoneAuthState) {
    val phoneNumber = viewModel.phoneNumber.collectAsState().value

    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).padding(top = 18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text("Enter OTP",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text("Put the OTP number below sent to your number   +91 ${phoneNumber}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = viewModel.otpCode.collectAsState().value,
            onValueChange = {if(it.length <= 6) viewModel.setOtpCode(it)},
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter OTP") },
            isError = viewModel.authState.collectAsState().value is PhoneAuthState.Error,
            shape = RoundedCornerShape(14.dp)
        )


    }

}