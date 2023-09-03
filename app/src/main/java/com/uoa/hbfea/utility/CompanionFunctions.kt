package com.uoa.hbfea.utility

import android.content.SharedPreferences
import android.util.Log
import com.uoa.hbfea.model.models.Result
import com.uoa.hbfea.model.repositories.UserRepository

class CompanionFunctions {
    companion object{

        suspend fun checkUser(userRepository: UserRepository,
                              token:String
        ):Boolean{
            Log.d("API Response Token", "Token Created: $token")
            var userExist=false
            when(val result = userRepository.getUserByPathParam(token))  {
                is Result.Success->{
                    userExist=true
//                    Toast.makeText(context,"You have already participated.\n Thank you!", Toast.LENGTH_LONG)
//                    Log.d("API Response", "Exists: ${result.data.id}")
                }
                is Result.Error -> {
                    userExist=false
//                    val exception = result.exception
//                    Log.d("API Response", "Failed to Get User", exception)

                    // Handle error
//                    Toast.makeText(context, "Welcome Participant!\n I am happy you are testing me", Toast.LENGTH_LONG).show()

                }
            }

            return userExist
        }



//        fun storeanRetrieveToken(context: Context):String{
//            val sharedPreferences: SharedPreferences = getSharedPreferences("MyAppPrefs", context.MODE_PRIVATE)
//            val token = sharedPreferences.getString("device_token", null)
//            val tok = intent.getStringExtra("token") as String


            //        if (token == null) {
//                        // Generate a new token for this device and store it
//                        val newToken=TokenGenerator.generateRandomString(10)
//                        sharedPreferences.edit().putString("device_token", newToken).apply()
//
//                    }
//        }
        const val PREFS_NAME = "MyPrefs"
        const val USER_TOKEN_KEY = "userToken"
    }
}