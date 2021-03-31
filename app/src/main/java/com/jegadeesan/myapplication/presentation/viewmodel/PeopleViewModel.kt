package com.jegadeesan.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jegadeesan.myapplication.data.model.PeopleList
import com.jegadeesan.myapplication.domain.usecase.FetchUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleViewModel(private val fetchUserUseCase: FetchUserUseCase): ViewModel() {

    private val _peopleList : MutableLiveData<PeopleList> = MutableLiveData()
    val peopleList: LiveData<PeopleList?>
        get() = _peopleList

    fun getPeople(): LiveData<PeopleList?> {
        viewModelScope.launch(Dispatchers.IO) {
            val peopleList = fetchUserUseCase.execute()
            _peopleList.postValue(peopleList)
        }
        return peopleList
    }

}