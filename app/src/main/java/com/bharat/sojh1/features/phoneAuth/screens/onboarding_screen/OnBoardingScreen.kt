package com.bharat.sojh1.features.phoneAuth.screens.onboarding_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bharat.sojh1.data.onBoardingItems
import com.bharat.sojh1.features.phoneAuth.screens.onboarding_screen.components.ArrowButton
import com.bharat.sojh1.features.phoneAuth.screens.onboarding_screen.components.CrousalDots
import com.bharat.sojh1.features.phoneAuth.screens.onboarding_screen.components.OnboardingCrousal
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(navigateToNumberScreen: () -> Unit) {
    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(pageCount = { onBoardingItems.size })

    LaunchedEffect(Unit) {
    while(true){
        delay(5000)
        if(!pagerState.isScrollInProgress){
            val nextPage = (pagerState.currentPage + 1) % onBoardingItems.size
            pagerState.scrollToPage(nextPage)
        }
    }
    }

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(top = 40.dp),

    ) {

        OnboardingCrousal(pagerState = pagerState, crousalItemsList = onBoardingItems)

        CrousalDots(onBoardingItems.size, pagerState.currentPage)

        TextButton(
            onClick = { navigateToNumberScreen() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            Text(text = "Skip", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
        }

        ArrowButton(modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick= {
                if(pagerState.currentPage < onBoardingItems.size - 1){
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else{
                    navigateToNumberScreen()
                }
        })




    }

}