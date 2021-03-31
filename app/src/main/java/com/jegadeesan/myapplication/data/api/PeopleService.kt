package com.jegadeesan.myapplication.data.api

import com.jegadeesan.myapplication.data.model.PeopleList
import retrofit2.Response
import retrofit2.http.GET

interface PeopleService {

    @GET("people/")
    suspend fun getPeople(): Response<PeopleList>

}