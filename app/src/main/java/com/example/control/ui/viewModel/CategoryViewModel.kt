package com.example.control.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.control.model.domain.Category
import com.example.control.model.repository.CategoryRepository
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