package com.app.interview

import android.app.Application
import com.app.interview.di.AppComponent
import com.app.interview.di.DaggerAppComponent

class MyApp : Application() {

   lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)
    }
}