package com.bytestore.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bytestore.app.repository.ArticlesRepository

class AppViewModelFactory(val repository: ArticlesRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ArticlesViewModel(repository) as T
}