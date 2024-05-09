package com.app.interview.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.interview.MyApp
import com.app.interview.R
import com.app.interview.data.model.University
import com.app.interview.databinding.ActivityDetailsScreenBinding
import com.app.interview.utils.Constant
import com.app.interview.view.viewmodels.MainViewModel
import com.app.interview.view.viewmodels.MainViewModelFactory
import com.google.gson.Gson
import javax.inject.Inject

class DetailsScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsScreenBinding

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details_screen)

        getData()

        binding.ivRefresh.setOnClickListener {
            val resultIntent = Intent()
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun getData() {
        val data =  Gson().fromJson(intent.getStringExtra(Constant.UNIVERSITY),University::class.java)
        data.let {
            binding.data = it
        }
    }
}