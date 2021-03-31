package com.jegadeesan.myapplication.presentation.di

import com.jegadeesan.myapplication.data.api.PeopleService
import com.jegadeesan.myapplication.data.repository.PeopleRemoteRepository
import com.jegadeesan.myapplication.domain.repository.PeopleRepository
import com.jegadeesan.myapplication.domain.usecase.FetchUserUseCase
import com.jegadeesan.myapplication.presentation.viewmodel.PeopleViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.binds
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single<Retrofit> { getRetrofit() }
    single<PeopleService> { get<Retrofit>().create(PeopleService::class.java) }
    single { PeopleRepository(get()) } binds arrayOf(PeopleRemoteRepository::class)
    single { FetchUserUseCase(get()) }
    viewModel { PeopleViewModel(get()) }

}

private fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}