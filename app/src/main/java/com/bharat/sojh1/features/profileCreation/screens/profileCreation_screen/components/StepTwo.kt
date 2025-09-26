package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.R
import com.bharat.sojh1.features.phoneAuth.PhoneAuthViewModal
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal
import com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.OptionsType
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StepTwo(viewModal : ProfileCreationViewModal, showSheet : MutableState<Boolean>, currentOptionsType : MutableState<OptionsType>, sheetState : SheetState) {
   val scope= rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
    ) {
        Text(
            "Tell us which class/grade and  school you study in?",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth().padding(bottom = 22.dp),
            textAlign = TextAlign.Center
        )

        //classGrade feild
        ButtonStepTextFeild(
            value = if (viewModal.classGrade.value != null) "Class ${viewModal.classGrade.value?.toString()}" else null,
            onClick = {
                currentOptionsType.value = OptionsType.ClassGrade
                showSheet.value = true
                scope.launch {
                    delay(200)
                    sheetState.expand()
                }
            },
            placeholder = "Select Grade",
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.class_grade), contentDescription = "name", modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "dropdown", tint = Color.Gray)
            }
        )

        Spacer(modifier = Modifier.height(18.dp))




        //school feild
        ButtonStepTextFeild(
            onClick = {
                currentOptionsType.value = OptionsType.School
                showSheet.value = true
                scope.launch {
                    delay(200)
                    sheetState.expand()
                }

            },
            value = if (viewModal.school.value != null) viewModal.school.value?.toString() else null,
            placeholder = "Select your school",
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.school), contentDescription = "name", modifier = Modifier.size(24.dp) ,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "dropdown", tint = Color.Gray)
            }
        )






    }

}