package com.alesh.domain.interactor

import com.alesh.domain.common.constant.SortingConstants
import com.alesh.domain.model.dto.User
import com.alesh.domain.model.result.Result
import com.alesh.domain.usecase.UserUseCase
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val userUseCase: UserUseCase
) {

    suspend fun getUsers(): Result<List<User>> {
        return userUseCase.getUsers()
    }

    suspend fun getUsersBySort(sort: SortingConstants): Result<List<User>> {
        return userUseCase.getUsersBySort(sort)
    }

    suspend fun getUserById(id: Int): Result<User> {
        return userUseCase.getUserById(id)
    }
}