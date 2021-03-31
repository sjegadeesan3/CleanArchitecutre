package com.jegadeesan.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jegadeesan.myapplication.R
import com.jegadeesan.myapplication.data.model.People

class PeopleAdapter(private val peopleList: List<People>):  RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.people_line_item, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.textView.text = peopleList[position].name
    }

    override fun getItemCount(): Int =
        peopleList.size

    class PeopleViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.people_name)
    }

}