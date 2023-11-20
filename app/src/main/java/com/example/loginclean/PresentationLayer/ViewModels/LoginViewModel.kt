package com.example.loginclean.PresentationLayer.ViewModels

import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginclean.PresentationLayer.Views.showToast
import com.example.loginclean.UseCases.LoginUsecase
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {
    var loginUseCase = LoginUsecase()
    private val _email = mutableStateOf(TextFieldValue())
    val email: MutableState<TextFieldValue> get() = _email


    private val _password = mutableStateOf(TextFieldValue())
    val password: State<TextFieldValue> = _password

//    private val _loginResult = mutableStateOf<Result<String>>(Result.success("Initial State"))
//    val loginResult: State<Result<String>> get() = _loginResult // for to observe


    fun updateEmail(newValue: TextFieldValue) {
        _email.value = newValue
    }

    fun updatePassword(passwordState: TextFieldValue) {
        _password.value = passwordState
    }

    interface ToastCallback {
        fun showToast(message: String)
    }

    var toastCallback: ToastCallback? = null

    fun login() {
        viewModelScope.launch {
            try {
                val result = loginUseCase.login(email.value.toString(), password.value.toString())
                if (result.isSuccessful) {
                    var response = result.body()
                    var token = response?.token
                    toastCallback?.showToast("Login Successful: $token")
                }

            } catch (e: Exception) {
                e.printStackTrace()
                toastCallback?.showToast("Error: ${e.message}")

            }


        }


    }
}










