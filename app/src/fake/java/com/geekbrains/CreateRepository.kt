package com.geekbrains

import com.geekbrains.tests.presenter.RepositoryContract
import com.geekbrains.tests.repository.FakeGitHubRepository

class CreateRepository {
    internal fun getRepo(): RepositoryContract = FakeGitHubRepository()
}