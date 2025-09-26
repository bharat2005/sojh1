package com.bharat.sojh1.features.subject.screens.bookmark_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BookMarkScreen() {
    Scaffold {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text("BookMarkScreen", style = MaterialTheme.typography.titleLarge)

        }
    }

}