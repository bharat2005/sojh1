package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal

data class ClassGradeOptions(
    val classId : Int?,
    val title : String
)
data class ClassSectionOption(
    val sectionTitle: String,
    val classes: List<ClassGradeOptions>
)

val primarySchool = ClassSectionOption(
    "Middle School",
    listOf(ClassGradeOptions(4, "Class 4"), ClassGradeOptions(5, "Class 5"), ClassGradeOptions(6, "Class 6"), ClassGradeOptions(7, "Class 7"), ClassGradeOptions(8, "Class 8"), ClassGradeOptions(9, "Class 9"), ClassGradeOptions(10, "Class 10"))
)
val highSchool = ClassSectionOption(
    "High School",
    listOf(ClassGradeOptions(11, "Class 11"), ClassGradeOptions(12, "Class 12") )
)

@Composable
fun ClassGradeOptions(viewModal: ProfileCreationViewModal, closeSheet : () -> Unit) {
    val selectdClass = viewModal.classGrade.value
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 28.dp)
            .padding(horizontal = 18.dp)
    ) {
        //title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Grade/Course",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = {closeSheet()}) {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = "Clear",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        for (section in listOf(primarySchool, highSchool)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)) {
                Text(
                    section.sectionTitle,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(12.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2)
                ) {
                    items(section.classes) { classGrade ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp, horizontal = 12.dp),
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .border(
                                       if(selectdClass == classGrade.classId) 2.dp else 1.dp,
                                        if(selectdClass == classGrade.classId) MaterialTheme.colorScheme.primary else Color.LightGray,
                                        RoundedCornerShape(12.dp)
                                    )
                                    .background(
                                        if(selectdClass == classGrade.classId) MaterialTheme.colorScheme.secondaryContainer else Color.White
                                    )
                                    .clickable(onClick = {
                                        viewModal.classGrade.value = classGrade.classId
                                        closeSheet()

                                    })
                                ,
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = classGrade.title,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )

                            }
                        }
                    }
                }
            }
        }


    }

}