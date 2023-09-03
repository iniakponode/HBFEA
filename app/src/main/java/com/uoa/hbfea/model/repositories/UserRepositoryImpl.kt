package com.uoa.hbfea.model.repositories

import android.util.Log
import com.uoa.hbfea.model.datasources.apiServices.RetrofitInstance
import com.uoa.hbfea.model.datasources.apiServices.UsersService
import com.uoa.hbfea.model.models.Result
import com.uoa.hbfea.model.models.Users
import com.uoa.hbfea.model.models.UsersItem

class UserRepositoryImpl : UserRepository {
    private val apiService = RetrofitInstance.getRetrofitInstance().create(UsersService::class.java)

    override suspend fun registerUser(newUser: UsersItem): Result<Pair<Int, UsersItem>>{
//        Result<UsersItem>
        return try {
            val response = apiService.postUser(newUser)

            if (response.isSuccessful) {
                val userId = response.body()?.id ?: 0
                Result.Success(userId to response.body()!!)
            } else if (response.code() == 500) {
                Result.Error(Exception("Check parameters passed for correct format")) // Handle the 404 error
            }
            else {
                Result.Error(Exception("Registration failed"))
            }



//            if (response.isSuccessful) {
//                Result.Success(response.body()!!)
//            } else {
//                Result.Error(Exception("Registration failed"))
//            }
//

        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getUserByQueryParam(token: String): Result<Users> {
        return try {
            val response = apiService.getUserByQueryParam(token)
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else if (response.code() == 500) {
                Result.Error(Exception("Check parameters passed for correct format")) // Handle the 404 error
            }
            else if (response.code() == 404) {
                Result.Error(Exception("User not found")) // Handle the 404 error
            }
            else {
                Result.Error(Exception("Failed to get user"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getUserByPathParam(token: String): Result<UsersItem> {
        return try {
            val response = apiService.getUserByPathParam(token)
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            }  else if (response.code() == 500) {
                Result.Error(Exception("Check parameters passed for correct format")) // Handle the 404 error
            }
            else if (response.code() == 404) {
                Result.Error(Exception("User not found")) // Handle the 404 error
            }
            else if (response.code() == 200) {
                Result.Error(Exception("User Found")) // Handle the 404 error
            }
            else {
                Log.d("API Response",response.code().toString())
                Result.Error(Exception("Failed to get user"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
