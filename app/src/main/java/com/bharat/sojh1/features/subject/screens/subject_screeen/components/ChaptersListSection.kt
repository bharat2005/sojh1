package com.bharat.sojh1.features.subject.screens.subject_screeen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.R
import com.bharat.sojh1.model.Subject

@Composable
fun ChaptersListSection(currentSubjectData : Subject, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier.fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
            .background(Color.White)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text("Chapters",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(vertical = 22.dp)
            )

            if(currentSubjectData.totalChapter.size != 0){

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(top = 24.dp, bottom = 24.dp)
                ) {

                    items(currentSubjectData.totalChapter) {
                            chapter ->

                        ChapterCard(chapter)
                    }

                }

            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painterResource(R.drawable.box),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(130.dp)
                        )




                }
            }




        }


    }

}