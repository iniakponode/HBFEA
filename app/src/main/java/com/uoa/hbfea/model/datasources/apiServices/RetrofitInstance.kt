package com.uoa.hbfea.model.datasources.apiServices

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        val BASE_URL="https://afternoon-sands-09358-f3e117e55365.herokuapp.com/"

        fun getRetrofitInstance():Retrofit{

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client((OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply { level=HttpLoggingInterceptor.Level.BODY })
                    .build()
                        )
                )
                .build()
        }
    }

}