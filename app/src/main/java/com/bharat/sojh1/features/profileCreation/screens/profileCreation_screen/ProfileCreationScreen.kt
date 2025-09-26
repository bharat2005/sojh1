package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components.ClassGradeOptions
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components.ConFinButton
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components.SchoolOptions
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components.StepIndicatorBar
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components.StepOne
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components.StepThree
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components.StepTwo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


sealed class OptionsType{

    object School : OptionsType()
    object ClassGrade : OptionsType()
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCreationScreen( viewModal : ProfileCreationViewModal, navigateBack : ()-> Boolean, navigateToMain : ()-> Unit) {
    val currentStep = viewModal.currentStep.collectAsState().value
    val pagerState = rememberPagerState(pageCount = { 3 }, initialPage = currentStep - 1)
    val focusManager = LocalFocusManager.current

    val scope = rememberCoroutineScope()

    LaunchedEffect(currentStep) {
        pagerState.animateScrollToPage(currentStep - 1)
    }

    //options type
    val currentOptionsType = remember {mutableStateOf<OptionsType>(OptionsType.ClassGrade)}

    //modalsheet
    val showSheet = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    fun closeSheet(){

        scope.launch {
            delay(300)
            sheetState.hide()
            delay(600)
            showSheet.value = false
        }
    }

    BackHandler {
        when(currentStep){
            1 -> {
                navigateBack()
            }
            2 -> {
                viewModal.prevStep()
            }
            3 -> {
                viewModal.prevStep()
            }
        }
    }

    Scaffold (
        topBar = {
            StepIndicatorBar(steps = 3, currrentStep = pagerState.currentPage)
        }
    ){
        paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
                .clickable(onClick = { focusManager.clearFocus()}, indication = null, interactionSource = remember { MutableInteractionSource() })
        ) {

            Column(
                modifier = Modifier.fillMaxWidth().height(720.dp).padding(top = 18.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth(),
                    userScrollEnabled = false
                ) { currentIndex ->
                    when (currentIndex + 1) {
                        1 -> StepOne(viewModal)
                        2 -> StepTwo(viewModal, showSheet, currentOptionsType, sheetState)
                        3 -> StepThree(viewModal)
                    }
                }

                ConFinButton(
                    viewModal,
                    pagerState.currentPage,
                    navigateToMain
                )



            }



            if(showSheet.value){
                ModalBottomSheet(
                    sheetState = sheetState,
                    dragHandle = {},
                    containerColor = MaterialTheme.colorScheme.background,
                    onDismissRequest = { showSheet.value = false }
                ) {
                    when(currentOptionsType.value){
                        OptionsType.ClassGrade -> ClassGradeOptions(viewModal,{closeSheet()} )
                        OptionsType.School -> SchoolOptions(viewModal, {closeSheet()} )
                    }

                }
            }



        }
    }
}
