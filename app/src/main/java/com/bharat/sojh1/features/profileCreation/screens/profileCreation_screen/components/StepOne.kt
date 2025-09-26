package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal
import com.bharat.sojh1.R

@Composable
fun StepOne(viewModal: ProfileCreationViewModal) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
    ) {
        Text(
            "Welcome to the world of learning, Lets start your registration",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth().padding(bottom = 22.dp),
            textAlign = TextAlign.Center
        )

        //name feild
       StepTextFeild(
              value = viewModal.name.value,
              onValueChange = { viewModal.name.value = it },
              placeholder = "Enter your name*",
           leadingIcon = {
               Icon(painter = painterResource(id = R.drawable.name), contentDescription = "name", modifier = Modifier.size(24.dp),
                   tint = MaterialTheme.colorScheme.primary
               )
           }
       )

        Spacer(modifier = Modifier.height(18.dp))

        //email feild
        StepTextFeild(
            value = viewModal.email.value,
            onValueChange = { viewModal.email.value = it },
            placeholder = "Enter your email ID*",
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.email), contentDescription = "name", modifier = Modifier.size(24.dp) ,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )


    }
}