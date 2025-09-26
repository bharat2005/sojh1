package com.bharat.sojh1.model

import androidx.compose.ui.graphics.Color

data class Subject(
     val subjectTitle : String,
    val backgroundImageRes : Int,
    val subjectId : String,
    val subjectColor : Color,
    val totalChapter : List<Chapter>
)
