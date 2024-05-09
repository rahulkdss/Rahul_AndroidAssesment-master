package com.app.interview.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.app.interview.view.activity.DetailsScreenActivity
import com.app.interview.view.activity.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DataBaseModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainActivity: DetailsScreenActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):AppComponent
    }
}