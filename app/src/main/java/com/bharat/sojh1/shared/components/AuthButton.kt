package com.bharat.sojh1.shared.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AuthButton(text : String, onClick : () -> Unit, enabled : Boolean, isLoading : Boolean, modifier : Modifier = Modifier, clearFocus : ()-> Unit) {

    Button (
        onClick = {
            clearFocus()
            onClick()
        },
        enabled = enabled,
        modifier = modifier
            .height(48.dp),
        shape = RoundedCornerShape(24.dp)

)
{
    if(isLoading){
        CircularProgressIndicator(color = Color.Gray, strokeWidth = 2.dp, modifier = Modifier.size(24.dp))
    } else {
        Text(text, style = MaterialTheme.typography.titleMedium)
    }
}

}