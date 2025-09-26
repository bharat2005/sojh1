package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal

@Composable
fun ConFinButton(viewModal: ProfileCreationViewModal, currentStep  : Int, navigateToMain : () -> Unit) {
    val focusManager = LocalFocusManager.current
    val isLoading = remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 28.dp),
        contentAlignment = Alignment.Center
    ){
        when(currentStep + 1){
            1 -> {
                val isValid = viewModal.name.value.isNotEmpty() && viewModal.email.value.isNotEmpty()
                Button(
                    onClick = {
                        focusManager.clearFocus()
                        viewModal.nextStep()
                              },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isValid
                ) {
                    Text("Continue", style= MaterialTheme.typography.titleMedium)
                }
            }
            2 -> {
                val isValid = (viewModal.classGrade.value != null) && (viewModal.school.value != null)
                Button(
                    onClick = {
                        focusManager.clearFocus()
                        viewModal.nextStep()
                              },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isValid
                ) {
                    Text("Continue", style= MaterialTheme.typography.titleMedium)
                }
            }
            3 -> {
                val isValid = viewModal.location.value.isNotEmpty()
                if(isValid){
                    Button(
                        onClick = {
                            focusManager.clearFocus()
                            isLoading.value = true
                            viewModal.finishForm(onSucces = {

                            }, OnError = {})
                        },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        if(isLoading.value){
                            CircularProgressIndicator(color = Color.Gray, strokeWidth = 2.dp, modifier = Modifier.size(24.dp))
                        } else{
                            Text("Start Learning", style= MaterialTheme.typography.titleMedium)
                        }

                    }
                }
            }
        }


    }

}