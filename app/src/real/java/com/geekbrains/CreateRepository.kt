package com.geekbrains

import com.geekbrains.tests.presenter.RepositoryContract
import com.geekbrains.tests.repository.GitHubApi
import com.geekbrains.tests.repository.GitHubRepository
import com.geekbrains.tests.view.search.MainActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreateRepository {
    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MainActivity.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    internal fun getRepo(): RepositoryContract = GitHubRepository(createRetrofit().create(GitHubApi::class.java))
}