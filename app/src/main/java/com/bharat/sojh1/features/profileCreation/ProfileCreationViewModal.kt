package com.bharat.sojh1.features.profileCreation

import android.Manifest
import android.content.Context
import android.location.Geocoder
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalDensity
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.LocationServices
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.logger.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale


class ProfileCreationViewModal : ViewModel(){

    private val _currentStep = MutableStateFlow<Int>(1)
    val currentStep = _currentStep


    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val school = mutableStateOf<String?>(null)
    val classGrade = mutableStateOf<Int?>(null)
    val location = mutableStateOf<String>("")



    fun nextStep(){
        if(_currentStep.value < 3 ){
            _currentStep.value++
        }
    }

    fun prevStep(){
        if(_currentStep.value > 1 ){
            _currentStep.value--
        }
    }


    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun fetchLocation(context : Context){
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener {
                if(it != null){
                    try{
                        val geocoder = Geocoder(context, Locale.getDefault())
                        val adresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                        if(adresses != null && adresses.isNotEmpty()){
                            val address = adresses[0]
                            location.value = "${address.featureName}, ${address.locality}, ${address.adminArea}, ${address.postalCode}, ${address.countryName}"
                        }
                    } catch (e : Exception){
                        location.value = "Error at catch"
                    }

                } else {
                    location.value = "Error at else"
                }
        }
            .addOnFailureListener {
                e ->
                location.value = "Error at fauiler"
            }
    }



    fun finishForm(onSucces : () -> Unit, OnError : () -> Unit){
        val db = FirebaseFirestore.getInstance()
        val auth = FirebaseAuth.getInstance()

        val formData = hashMapOf(
            "name" to name.value,
            "email" to email.value,
            "phoneNumber" to auth.currentUser?.phoneNumber,
            "classGrade" to classGrade.value,
            "school" to school.value,
            "location" to location.value
        )

        db.collection("users")
            .document(auth.currentUser!!.uid)
            .set(formData)
            .addOnSuccessListener { docRef ->
                Log.d("FireStroeScuess", "docId: ${"kn"}")
                onSucces()
            }
            .addOnFailureListener { e ->
                Log.w("FireStoreError", "Error adding document", e)
                OnError()

            }



    }


}