package com.bharat.sojh1.features

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class AppViewModal : ViewModel() {

    sealed class AuthState {
        object Loading : AuthState()
        object UnAuthenticated : AuthState()
        object ProfileNotCreated : AuthState()
        object Authenticated : AuthState()
    }

    val auth = FirebaseAuth.getInstance()
    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)
    val authState: StateFlow<AuthState> = _authState


    private val authListner = FirebaseAuth.AuthStateListener { firebaseAuth ->

        if (firebaseAuth.currentUser != null) {
            FirebaseFirestore.getInstance().collection("users")
                .document(firebaseAuth.currentUser!!.uid)
                .addSnapshotListener { snapShot, error ->
                    if(error != null){
                        _authState.value = AuthState.UnAuthenticated
                        return@addSnapshotListener
                    }
                    if(snapShot != null && snapShot.exists()){
                        _authState.value = AuthState.Authenticated
                    } else {
                        _authState.value = AuthState.ProfileNotCreated
                    }
                }

        } else {
            _authState.value = AuthState.UnAuthenticated
        }

    }


    init {
        auth.addAuthStateListener(authListner)
    }

    fun signOut() {
        auth.signOut()
    }


    override fun onCleared() {
        super.onCleared()
        auth.removeAuthStateListener(authListner)
    }


}