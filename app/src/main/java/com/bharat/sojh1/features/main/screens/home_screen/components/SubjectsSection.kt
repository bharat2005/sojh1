package com.bharat.sojh1.features.main.screens.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bharat.sojh1.data.subjectsDataList
import com.bharat.sojh1.features.subject.navigation.SubjectRoutes


@Composable
fun SubjectsSection(appNavController: NavHostController) {


    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)
    ) {

        Text(
            "All Subjects",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 12.dp)

        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(subjectsDataList){
                subject ->
                Box(
                    modifier = Modifier.fillMaxWidth().height(84.dp).padding(horizontal = 6.dp),
                    contentAlignment = Alignment.Center
                ){
                    SubjectCard(subject,  {appNavController.navigate(SubjectRoutes.createRoute(subject.subjectId)) })
                }

            }

        }

    }

}