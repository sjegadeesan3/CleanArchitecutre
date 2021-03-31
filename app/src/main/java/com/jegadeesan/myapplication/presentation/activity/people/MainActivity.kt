package com.jegadeesan.myapplication.presentation.activity.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jegadeesan.myapplication.R
import com.jegadeesan.myapplication.databinding.ActivityMainBinding
import com.jegadeesan.myapplication.presentation.adapter.PeopleAdapter
import com.jegadeesan.myapplication.presentation.viewmodel.PeopleViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val peopleViewModel: PeopleViewModel by inject()

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
        peopleViewModel.getPeople().observe(this, Observer {
            it?.let { peopleList ->
                val recyclerView = binding.peopleRecyclerView
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = PeopleAdapter(peopleList.people)
            }

        })
    }

}