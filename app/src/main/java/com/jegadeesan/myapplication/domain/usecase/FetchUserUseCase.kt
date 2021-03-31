package com.jegadeesan.myapplication.domain.usecase

import com.jegadeesan.myapplication.data.model.PeopleList
import com.jegadeesan.myapplication.data.repository.PeopleRemoteRepository

class FetchUserUseCase(private val peopleRemoteRepository: PeopleRemoteRepository): UseCase<PeopleList?> {

    override suspend fun execute(): PeopleList? {
        return peopleRemoteRepository.getAllPeople()
    }

}

interface  UseCase<T> {
    suspend fun execute(): T
}