package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal

@Composable
fun LocationSection(viewModal: ProfileCreationViewModal) {
    val openButtons = remember { mutableStateOf(true) }
    val context = LocalContext.current

    val hasLocationPermission = remember {
      mutableStateOf(
          ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
      )
    }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            hasLocationPermission.value = isGranted
            if(isGranted){
                viewModal.fetchLocation(context)
                openButtons.value = false
            }
        }
    )


    if (openButtons.value && viewModal.location.value.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp, vertical = 22.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    if(hasLocationPermission.value){
                        viewModal.fetchLocation(context)
                        openButtons.value = false
                    }else{
                        locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                    }
                },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Allow Location Services",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }
            Text(
                "Or",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground
            )

            OutlinedButton(
                onClick = {openButtons.value = false },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary),
            ) {
                Text(
                    "Enter Location Manually",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

        }

    } else {
        OutlinedTextField(
            value = viewModal.location.value,
            shape = RoundedCornerShape(12.dp),
            onValueChange = { viewModal.location.value = it },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedPlaceholderColor = Color.LightGray,
                unfocusedPlaceholderColor = Color.LightGray,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp)
                .heightIn(min = 80.dp, max = 120.dp),
            placeholder = { Text("Innovation Studio, Lovely Professional Studio, Phagware, Punjab") },
            leadingIcon = {
                Icon(Icons.Default.LocationOn, contentDescription = "location", tint = MaterialTheme.colorScheme.primary)
            }
        )
        TextButton(
            onClick = {
                openButtons.value = true
                viewModal.location.value = ""
            }
        ) {
            Text("change", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(vertical = 8.dp ))
        }

    }

}