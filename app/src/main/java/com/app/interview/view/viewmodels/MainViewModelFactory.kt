package com.app.interview.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.interview.data.repository.UniversityRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val universityRepository: UniversityRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(universityRepository) as T
    }
}
