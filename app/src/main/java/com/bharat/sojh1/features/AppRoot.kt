package com.bharat.sojh1.features

import android.provider.ContactsContract
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.bharat.sojh1.features.main.navigation.MainRoutes
import com.bharat.sojh1.features.main.navigation.mainNavGraph
import com.bharat.sojh1.features.phoneAuth.navigation.PhoneAuthRoutes
import com.bharat.sojh1.features.phoneAuth.navigation.phoneAuthGraph
import com.bharat.sojh1.features.profileCreation.navigation.ProfileCreationRoutes
import com.bharat.sojh1.features.profileCreation.navigation.profileCreationNavGraph
import com.bharat.sojh1.features.subject.navigation.SubjectRoutes
import com.bharat.sojh1.features.subject.navigation.subjectNavGraph
import com.bharat.sojh1.features.subject.screens.subject_screeen.SubjectScreen
import com.bharat.sojh1.shared.components.SplashScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AppRoot(viewModal: AppViewModal = viewModel()) {
    val appNavController : NavHostController = rememberNavController()
     val authState = viewModal.authState.collectAsState().value
        val startDestination = remember { mutableStateOf("splash_screen") }


    LaunchedEffect(authState) {
        when (authState) {
            AppViewModal.AuthState.Loading -> startDestination.value = "splash_screen"

            AppViewModal.AuthState.UnAuthenticated -> {
                appNavController.navigate(PhoneAuthRoutes.PHONE_AUTH) {
                    popUpTo(0)
                }
            }

            AppViewModal.AuthState.ProfileNotCreated -> {
                appNavController.navigate(ProfileCreationRoutes.PROFILE_CREATION) {
                    popUpTo(0)
                }
            }

            AppViewModal.AuthState.Authenticated -> {
                appNavController.navigate(MainRoutes.MAIN) {
                                popUpTo(0)
                }
            }

            }
        }



    NavHost(
        startDestination = startDestination.value,
        navController = appNavController
    ){

        composable("splash_screen") { SplashScreen() }
        phoneAuthGraph(appNavController)
        profileCreationNavGraph(appNavController)
        mainNavGraph(appNavController)
        subjectNavGraph(appNavController)


    }

}