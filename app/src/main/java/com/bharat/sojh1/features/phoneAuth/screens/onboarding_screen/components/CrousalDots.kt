package com.bharat.sojh1.features.phoneAuth.screens.onboarding_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CrousalDots(dotsCount : Int, currentCrousalIndex : Int) {
    Row (
        modifier = Modifier.fillMaxWidth().padding(vertical = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally),
    ){
        repeat(dotsCount){
            index ->
            val  isSelected = currentCrousalIndex == index
            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(if (isSelected) 20.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) MaterialTheme.colorScheme.onBackground else Color.LightGray  )
            )
        }

    }

}