package com.uoa.hbfea.model.datasources.apiServices

import com.uoa.hbfea.model.models.Users
import com.uoa.hbfea.model.models.UsersItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersService {
    @POST("safe-drive-ng-api/v1/users/register/")
    suspend fun postUser(@Body user:UsersItem): Response<UsersItem>

    @GET("safe-drive-ng-api/v1/users/users/")
    suspend fun getUserByQueryParam(@Query("token") token:String): Response<Users>

    @GET("safe-drive-ng-api/v1/users/users/{token}/")
    suspend fun getUserByPathParam(@Path("token") token:String): Response<UsersItem>

}