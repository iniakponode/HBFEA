package com.uoa.hbfea.model.repositories

import com.uoa.hbfea.model.models.Result
import com.uoa.hbfea.model.models.Users
import com.uoa.hbfea.model.models.UsersItem

interface UserRepository {
    suspend fun registerUser(newUser: UsersItem): Result<Pair<Int, UsersItem>>
    suspend fun getUserByQueryParam(token: String): Result<Users>
    suspend fun getUserByPathParam(token: String): Result<UsersItem>
}