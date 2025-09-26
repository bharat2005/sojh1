package com.bharat.sojh1.features.main.screens.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bharat.sojh1.features.AppViewModal
import com.bharat.sojh1.features.main.screens.home_screen.components.DrawerSheet
import com.bharat.sojh1.features.main.screens.home_screen.components.MainTopBar
import com.bharat.sojh1.features.main.screens.home_screen.components.SubjectsSection

@Composable
fun HomeScreen(appNavController : NavHostController, viewModal: AppViewModal = viewModel()) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerSheet() }
    ) {
        Scaffold(
            topBar = { MainTopBar(drawerState) }
        ){
            paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).padding(top = 12.dp)
            ) {
                SubjectsSection(appNavController)
            }

        }
    }

}

