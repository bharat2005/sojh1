package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonStepTextFeild(value : String?, placeholder : String, modifier: Modifier = Modifier, leadingIcon : @Composable (() -> Unit)? = null, trailingIcon : @Composable (() -> Unit)? = null, onClick : () -> Unit) {


        OutlinedTextField(
            value = value ?: "",
            modifier = Modifier.fillMaxWidth().clickable(onClick = {onClick()}, indication = null, interactionSource = remember { MutableInteractionSource() }),
            shape = RoundedCornerShape(14.dp),
            singleLine = true,
            enabled = false,
            readOnly = true,
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(
                disabledContainerColor = Color.White,
                disabledTextColor = MaterialTheme.colorScheme.onBackground
            ),
            placeholder = { Text(placeholder) },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )


}