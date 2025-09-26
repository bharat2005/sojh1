package com.bharat.sojh1.features.subject.screens.subject_screeen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.bharat.sojh1.data.subjectsDataList
import com.bharat.sojh1.features.subject.screens.subject_screeen.components.ChaptersListSection
import com.bharat.sojh1.features.subject.screens.subject_screeen.components.SubjectScreenTopBar
import com.bharat.sojh1.features.subject.screens.subject_screeen.components.SubjectTopSection
import com.bharat.sojh1.model.Subject

@Composable
fun SubjectScreen(subjectId : String,  navigateBack : ()-> Boolean, navigateToBookMark : ()-> Unit) {
    val currentSubjectData = subjectsDataList.find { it.subjectId == subjectId}



        Scaffold(
            topBar = { SubjectScreenTopBar(navigateBack, navigateToBookMark, currentSubjectData!!.subjectColor) },
        ) { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).background(currentSubjectData!!.subjectColor)
            ) {

                SubjectTopSection(currentSubjectData)

                ChaptersListSection(currentSubjectData, modifier = Modifier.weight(1f))




            }
        }


}