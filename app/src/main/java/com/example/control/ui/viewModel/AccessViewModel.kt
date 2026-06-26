package com.example.control.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlin.Boolean


class AccessViewModel  : ViewModel() {
    private val _pin = MutableLiveData<String>()
    val pin: LiveData<String> = _pin
    private val _loginEnable = MutableLiveData<Boolean?>()
    val loginEnable: MutableLiveData<Boolean?> = _loginEnable
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean> = _isLoading

    fun onLoginChanged(pin: String) {
        _pin.value = pin
        _loginEnable.value = isValidPin(pin)
    }

    private fun isValidPin(pin: String): Boolean? {
        return pin.length == 4 && pin.all { it.isDigit() }
    }

    suspend fun onLoginSelected() {
        _isLoading.value = true
        delay(400)
        _isLoading.value = false
    }
}