package com.example.control.ui.theme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.control.data.CategoryRepository
import com.example.control.domain.Category
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CategoryViewModel (
    private val categoryRepository: CategoryRepository
): ViewModel(){

    val categories = categoryRepository.getAllCategories()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    fun addCategory(category: Category){
        viewModelScope.launch {
            categoryRepository.insertCategory(category)
        }
    }
}