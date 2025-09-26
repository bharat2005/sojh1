package com.bharat.sojh1.features.phoneAuth.navigation

import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bharat.sojh1.features.main.navigation.MainRoutes
import com.bharat.sojh1.features.phoneAuth.PhoneAuthViewModal
import com.bharat.sojh1.features.phoneAuth.screens.number_screen.NumberScreen
import com.bharat.sojh1.features.phoneAuth.screens.onboarding_screen.OnBoardingScreen
import com.bharat.sojh1.features.phoneAuth.screens.otp_screen.OtpScreen
import com.bharat.sojh1.features.profileCreation.navigation.ProfileCreationRoutes

fun NavGraphBuilder.phoneAuthGraph(appNavController : NavHostController){
    navigation(
        route = PhoneAuthRoutes.PHONE_AUTH,
        startDestination = PhoneAuthRoutes.ON_BOARDING_SCREEN,
    ){

        composable(PhoneAuthRoutes.ON_BOARDING_SCREEN) {
            OnBoardingScreen(navigateToNumberScreen = { appNavController.navigate(PhoneAuthRoutes.NUMBER_SCREEN) })
        }
        composable(PhoneAuthRoutes.NUMBER_SCREEN) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {appNavController.getBackStackEntry(PhoneAuthRoutes.PHONE_AUTH)}
            val viewModal = viewModel<PhoneAuthViewModal>(parentEntry)

            NumberScreen(viewModal = viewModal, navigateToOtpScreen = { appNavController.navigate(PhoneAuthRoutes.OTP_SCREEN) },
                navigateBack = {appNavController.popBackStack()})
        }


        composable(PhoneAuthRoutes.OTP_SCREEN) {backStackEntry ->
            val parentEntry = remember(backStackEntry) {appNavController.getBackStackEntry(PhoneAuthRoutes.PHONE_AUTH)}
            val viewModal = viewModel<PhoneAuthViewModal>(parentEntry)

            OtpScreen(viewModal  = viewModal, navigateBack = {appNavController.popBackStack()}
            )
        }

    }

}