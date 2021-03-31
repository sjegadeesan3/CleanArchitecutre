package com.jegadeesan.myapplication.domain.repository

import com.jegadeesan.myapplication.data.api.PeopleService
import com.jegadeesan.myapplication.data.model.PeopleList
import com.jegadeesan.myapplication.data.repository.PeopleRemoteRepository

class PeopleRepository(private val peopleService: PeopleService): PeopleRemoteRepository {

    override suspend fun getAllPeople(): PeopleList? {
        val people = peopleService.getPeople()

        return if(people.isSuccessful) {
            try {
                people.body()
            } catch (e: Exception) {
                return null
            }
        } else {
            null
        }
    }

}