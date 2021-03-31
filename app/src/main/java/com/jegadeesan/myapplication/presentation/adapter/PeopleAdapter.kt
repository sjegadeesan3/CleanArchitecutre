package com.jegadeesan.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jegadeesan.myapplication.data.model.People
import com.jegadeesan.myapplication.databinding.PeopleLineItemBinding

class PeopleAdapter(private val peopleList: List<People>):  RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = PeopleLineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.binding.peopleName.text = peopleList[position].name
    }

    override fun getItemCount(): Int =
        peopleList.size

    class PeopleViewHolder(peopleLineItemBinding: PeopleLineItemBinding): RecyclerView.ViewHolder(peopleLineItemBinding.root) {
        val binding: PeopleLineItemBinding = peopleLineItemBinding
    }

}