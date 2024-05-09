package com.app.interview.data.api

import com.app.interview.data.model.University
import retrofit2.Response
import retrofit2.http.GET

interface UniversityApiService {

    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversities(): Response<List<University>>
}