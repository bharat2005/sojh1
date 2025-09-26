package com.bharat.sojh1.features.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bharat.sojh1.features.main.screens.home_screen.HomeScreen


fun NavGraphBuilder.mainNavGraph(appNavController: NavHostController){
    navigation(
        route = MainRoutes.MAIN,
        startDestination = MainRoutes.HOME_SCREEN
    ){

        composable(MainRoutes.HOME_SCREEN){
            HomeScreen(appNavController)
        }

    }

}