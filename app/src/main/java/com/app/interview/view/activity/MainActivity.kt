package com.app.interview.view.activity

//import com.app.interview.view.viewmodels.MainViewModelFactory
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.interview.MyApp
import com.app.interview.R
import com.app.interview.data.model.University
import com.app.interview.databinding.ActivityMainBinding
import com.app.interview.utils.Constant
import com.app.interview.view.adapter.UniversityAdapter
import com.app.interview.view.adapter.UniversityAdapterListener
import com.app.interview.view.viewmodels.MainViewModel
import com.app.interview.view.viewmodels.MainViewModelFactory
import com.google.gson.Gson
import javax.inject.Inject


class MainActivity : AppCompatActivity(), UniversityAdapterListener {

    private lateinit var mainViewModel: MainViewModel

    private lateinit var universityAdapter: UniversityAdapter

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as MyApp).appComponent.inject(this)

        setAdapter()
        getData()
    }

    private fun getData() {
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.list.observe(this) {
            binding.progress.visibility = View.GONE
            universityAdapter.updateData(it)
            if (it.isEmpty())
                binding.tvNoRecord.visibility = View.VISIBLE
            else
                binding.tvNoRecord.visibility = View.GONE
        }
    }

    private fun setAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        universityAdapter = UniversityAdapter(emptyList(), this)
        binding.recyclerView.adapter = universityAdapter
    }

    override fun onUniversityAdapterClick(university: University, position: Int) {
        val myIntent = Intent(this@MainActivity, DetailsScreenActivity::class.java)
        val convertJsonString = Gson().toJson(university)
        myIntent.putExtra(Constant.UNIVERSITY, convertJsonString)
        myIntent.putExtra(Constant.SELECTED_POSITION, position)
        startActivityForResult(myIntent, Constant.RESULT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constant.RESULT && resultCode == Activity.RESULT_OK) {
            binding.progress.visibility = View.VISIBLE
            mainViewModel.refreshApi()
        }
    }
}