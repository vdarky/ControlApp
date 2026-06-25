package com.example.control.ui.theme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.control.data.repository.UserRepository
import com.example.control.domain.User
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AccessViewModel (
    private val userRepository: UserRepository
): ViewModel(){

    val categories = userRepository.getAllCategories()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    fun addCategory(){
        viewModelScope.launch {
            userRepository.insert(idUser)
        }
    }
}