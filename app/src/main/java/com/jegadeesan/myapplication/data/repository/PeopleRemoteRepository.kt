package com.jegadeesan.myapplication.data.repository

import com.jegadeesan.myapplication.data.model.PeopleList

interface PeopleRemoteRepository {
    suspend fun getAllPeople(): PeopleList?
}