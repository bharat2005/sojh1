package com.bharat.sojh1.features.subject.screens.subject_screeen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.bharat.sojh1.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bharat.sojh1.model.Chapter
import com.bharat.sojh1.ui.theme.QuickSand

@Composable
fun ChapterCard(chapter : Chapter) {

    Card(
        modifier = Modifier.fillMaxWidth().height(94.dp),
        shape = RoundedCornerShape(14.dp),
        onClick = {},
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().background(Color.White).padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .height(72.dp).aspectRatio(1f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFECECEC)),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painterResource(chapter.chapterImageRes),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(44.dp).aspectRatio(1f),
                    contentDescription = null
                )

            }
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight().padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(chapter.chapterTitle,
                    fontWeight = FontWeight.Bold,
                    fontFamily = QuickSand,
                    fontSize = 16.sp
                    )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("0", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleSmall)
                    Text("Videos", color = Color.Gray, style = MaterialTheme.typography.titleSmall)

                }

            }


        }



    }


}