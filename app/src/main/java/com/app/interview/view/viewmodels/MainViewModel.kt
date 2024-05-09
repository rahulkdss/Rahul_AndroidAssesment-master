package com.app.interview.view.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.interview.data.model.University
import com.app.interview.data.repository.UniversityRepository
import kotlinx.coroutines.launch

class MainViewModel(val universityRepository: UniversityRepository) : ViewModel() {
    val list: LiveData<List<University>>
        get() = universityRepository.list

    init {
        viewModelScope.launch {
            universityRepository.getUniversities()
        }
    }

    fun refreshApi(){
        viewModelScope.launch {
            universityRepository.getUniversities()
        }
    }
}