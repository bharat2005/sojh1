package com.bharat.sojh1.features.main.screens.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bharat.sojh1.model.Subject
import com.bharat.sojh1.ui.theme.QuickSand

@Composable
fun SubjectCard(subject: Subject,  onSubjectClick : () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(6.dp)),
        onClick = onSubjectClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(subject.subjectColor)
                .padding(vertical = 8.dp)
                .padding(start = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                subject.subjectTitle,
                fontFamily = QuickSand,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Image(
                painterResource(subject.backgroundImageRes),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )

        }

    }

}