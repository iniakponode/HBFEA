package com.uoa.hbfea.model.datasources

import com.uoa.hbfea.model.datasources.apiServices.UsersService
import com.uoa.hbfea.model.models.Users
import com.uoa.hbfea.model.models.UsersItem
import retrofit2.Response

class UserServiceImpl:UsersService {
    override suspend fun postUser(user: UsersItem): Response<UsersItem> {
        return this.postUser(user)
    }

    override suspend fun getUserByQueryParam(token: String): Response<Users> {
        return this.getUserByQueryParam(token)
    }

    override suspend fun getUserByPathParam(token: String): Response<UsersItem> {
        return this.getUserByPathParam(token)
    }
}