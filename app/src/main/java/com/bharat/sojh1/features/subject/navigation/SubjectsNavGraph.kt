package com.bharat.sojh1.features.subject.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.bharat.sojh1.features.subject.screens.bookmark_screen.BookMarkScreen
import com.bharat.sojh1.features.subject.screens.subject_screeen.SubjectScreen

fun NavGraphBuilder.subjectNavGraph(appNavController: NavHostController){
    navigation(
        startDestination = SubjectRoutes.SUBJECT_SCREEN,
        route = SubjectRoutes.SUBJECT_GRAPH
    ){
        composable(SubjectRoutes.SUBJECT_SCREEN,
            arguments = listOf(
                navArgument("subjectId"){
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId") ?: ""
             val navigateback = {appNavController.popBackStack()}
            val navigateToBookMarksSceen = {appNavController.navigate(SubjectRoutes.BOOKMARK_SCREEN)}
            SubjectScreen(subjectId, navigateback, navigateToBookMarksSceen)
        }

        composable(SubjectRoutes.BOOKMARK_SCREEN) { BookMarkScreen() }

    }
}