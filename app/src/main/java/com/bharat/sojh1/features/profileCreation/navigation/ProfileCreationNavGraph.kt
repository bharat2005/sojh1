package com.bharat.sojh1.features.profileCreation.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bharat.sojh1.features.main.navigation.MainRoutes
import com.bharat.sojh1.features.phoneAuth.PhoneAuthState
import com.bharat.sojh1.features.phoneAuth.PhoneAuthViewModal
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.ProfileCreationScreen


fun NavGraphBuilder.profileCreationNavGraph(appNavController : NavHostController){
    navigation(
        route = ProfileCreationRoutes.PROFILE_CREATION,
        startDestination = ProfileCreationRoutes.PROFILE_CREATION_SCREEN
    ){
        composable(ProfileCreationRoutes.PROFILE_CREATION_SCREEN){
            val viewModel : ProfileCreationViewModal = viewModel()
            val navigateBack = {appNavController.popBackStack()}
            val navigateToMain = {appNavController.navigate(MainRoutes.MAIN){
                popUpTo(ProfileCreationRoutes.PROFILE_CREATION){inclusive = true}
            } }
            ProfileCreationScreen(viewModel, navigateBack, navigateToMain)
        }

    }

}