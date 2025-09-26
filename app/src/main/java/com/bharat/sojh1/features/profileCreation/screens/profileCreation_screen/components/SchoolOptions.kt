package com.bharat.sojh1.features.profileCreation.screens.profileCreation_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bharat.sojh1.data.pubjabSchoolsList
import com.bharat.sojh1.features.profileCreation.ProfileCreationViewModal

@Composable
fun SchoolOptions(viewModal: ProfileCreationViewModal, closeSheet : () -> Unit) {
    val queryText = remember { mutableStateOf("") }

    val filteredSchoolLis = remember(queryText.value){
        pubjabSchoolsList.filter{
            school ->
            school.name.contains(queryText.value, ignoreCase = true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(740.dp)
            .padding(top = 24.dp)
            .padding(horizontal = 18.dp)
    ) {
        //title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Punjab Government Schools",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = { closeSheet() }) {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = "Clear",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        StepTextFeild(
            value = queryText.value,
            onValueChange = {queryText.value = it},
            placeholder = "Search your school",
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            },
        )
        Spacer(modifier = Modifier.height(18.dp))
        LazyColumn(

        ) {
            items(filteredSchoolLis){
                item ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clickable{
                            viewModal.school.value = item.name
                            closeSheet()
                        }
                        .padding(horizontal = 6.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(painterResource(item.icon), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxHeight().size(32.dp).aspectRatio(1f))
                    Text(item.name, modifier = Modifier.padding(start = 8.dp).weight(1f).padding(vertical = 12.dp), color = MaterialTheme.colorScheme.onBackground)
                }
            }
        }






    }

}