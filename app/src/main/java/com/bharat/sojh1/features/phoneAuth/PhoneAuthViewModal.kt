package com.bharat.sojh1.features.phoneAuth

import android.app.Activity
import androidx.credentials.Credential
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


sealed class PhoneAuthState{
    object Ideal : PhoneAuthState()
    object Loading : PhoneAuthState()
    object OtpEntry : PhoneAuthState()
    data class Error(val message : String) : PhoneAuthState()
    object Success : PhoneAuthState()
}

class PhoneAuthViewModal : ViewModel() {
    val auth = FirebaseAuth.getInstance()

    private var storedVerificationId: String? = null
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null
    private val _authState = MutableStateFlow<PhoneAuthState>(PhoneAuthState.Ideal)
    val authState: StateFlow<PhoneAuthState> = _authState

    private val _phoneNumber = MutableStateFlow<String>("")
    val phoneNumber: StateFlow<String> = _phoneNumber

    private val _otpCode = MutableStateFlow<String>("")
    val otpCode: StateFlow<String> = _otpCode

    private val _timer = MutableStateFlow<Int>(0)
    val timer : StateFlow<Int> = _timer

    private val _canResend = MutableStateFlow<Boolean>(false)
    val canResend : StateFlow<Boolean> = _canResend

    private var timerJob : Job? = null

    fun startTimer(){
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            _timer.value = 60
            _canResend.value = false
            while (_timer.value  > 0){
                delay(1000)
                _timer.value--
            }
            _canResend.value = true
            }
        }

    fun setPhoneNumber(newPhoneNumber: String) {
        _phoneNumber.value = newPhoneNumber
    }

    fun setOtpCode(newOtpCode: String) {
        _otpCode.value = newOtpCode

    }


    fun sendVerificationCode(activity: Activity) {
        val currentNumber = "+91" + _phoneNumber.value

        _authState.value = PhoneAuthState.Loading


        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(currentNumber)
            .setTimeout(0L, java.util.concurrent.TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    _authState.value = PhoneAuthState.Error("Verification Failer: ${e.message}")
                }

                override fun onCodeSent( verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                    storedVerificationId = verificationId
                    resendToken = token
                    _authState.value = PhoneAuthState.OtpEntry
                }

            })
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun resendVerificationCode(activity: Activity){
        startTimer()

        val currentNumber = "+91" + _phoneNumber.value

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(currentNumber)
            .setTimeout(0L, java.util.concurrent.TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    _authState.value = PhoneAuthState.Error("Verification Failer: ${e.message}")
                }

                override fun onCodeSent( verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                    storedVerificationId = verificationId
                    resendToken = token
                }

            }).setForceResendingToken(resendToken!!)
            .build()


        PhoneAuthProvider.verifyPhoneNumber(options)

    }

    fun verifyOtp(){
        _authState.value = PhoneAuthState.Loading
       val credential  = PhoneAuthProvider.getCredential(storedVerificationId!!, _otpCode.value)
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential).await()
                _authState.value = PhoneAuthState.Success
            }catch (e : Exception){
                _authState.value = PhoneAuthState.Error("Sign In Failed: ${e.message}")
            }

        }
    }

    fun resetStateForPhoneNumberEntry(fromNumber : Boolean = false){
        _authState.value = PhoneAuthState.Ideal
        if(fromNumber){
            _phoneNumber.value = ""
        }
        _otpCode.value = ""
        resendToken = null
        storedVerificationId = null
        timerJob?.cancel()

    }

}