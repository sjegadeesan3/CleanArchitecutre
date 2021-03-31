package com.jegadeesan.myapplication.presentation.activity.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jegadeesan.myapplication.data.model.PeopleList
import com.jegadeesan.myapplication.databinding.ActivityMainBinding
import com.jegadeesan.myapplication.presentation.adapter.PeopleAdapter
import com.jegadeesan.myapplication.presentation.viewmodel.PeopleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val peopleViewModel: PeopleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {
        inflateUi()
    }

    private fun inflateUi() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initData() {
        peopleViewModel.getPeople().observe(this, {
            it?.let { peopleList ->
                initRecyclerView(peopleList)
            }
        })
    }

    private fun initRecyclerView(peopleList: PeopleList) {
        val recyclerView = binding.peopleRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PeopleAdapter(peopleList.people)
    }

}