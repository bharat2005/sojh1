package com.bharat.sojh1.features.main.screens.home_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DrawerSheet(modifier: Modifier = Modifier) {
    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.72f)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {


        }

    }
}