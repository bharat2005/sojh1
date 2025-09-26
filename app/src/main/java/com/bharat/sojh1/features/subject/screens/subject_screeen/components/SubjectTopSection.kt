package com.bharat.sojh1.features.subject.screens.subject_screeen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.model.Subject
import com.bharat.sojh1.R

@Composable
fun SubjectTopSection(currentSubjectData : Subject) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
        ) {
            Text(
                currentSubjectData.subjectTitle,
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Icon(painterResource(R.drawable.class_grade), tint = MaterialTheme.colorScheme.primary, contentDescription = null, modifier = Modifier.size(22.dp))
                Text(
                    "${currentSubjectData.totalChapter.size} Chapters",
                    style = MaterialTheme.typography.bodyLarge

                    )

            }
        }

        Image(painterResource(currentSubjectData.backgroundImageRes), contentDescription = null,
            modifier = Modifier.height(120.dp)
            )


    }

}