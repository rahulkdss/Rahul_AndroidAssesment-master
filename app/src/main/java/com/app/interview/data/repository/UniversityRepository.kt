package com.app.interview.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.interview.data.api.UniversityApiService
import com.app.interview.data.database.AppDatabase
import com.app.interview.data.model.University
import javax.inject.Inject

class UniversityRepository @Inject constructor(
    private val apiService: UniversityApiService,
    private val appDatabase: AppDatabase
) {

    private val _list = MutableLiveData<List<University>>()
    val list: LiveData<List<University>>
        get() = _list

    suspend fun getUniversities() {
        try {
            val result = apiService.getUniversities()
            if (result.isSuccessful && result.body() != null) {
                appDatabase.universityDao().insertUniversities(result.body()!!)
                _list.postValue(result.body())
            }
        } catch (e: Exception) {
            _list.postValue(appDatabase.universityDao().getAllUniversities())
        }
    }
}