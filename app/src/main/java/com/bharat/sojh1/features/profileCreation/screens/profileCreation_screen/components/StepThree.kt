package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.R
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal

@Composable
fun StepThree(viewModal: ProfileCreationViewModal) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
    ) {
        Text(
            "We need your location details so that we can provide you localized content",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth().padding(bottom = 22.dp),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painterResource(R.drawable.location),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(220.dp)
            )
        }

        LocationSection(viewModal)


    }

}