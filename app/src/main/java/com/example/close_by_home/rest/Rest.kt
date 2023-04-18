package com.example.close_by_home.rest
import  retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    private val BASE_URL = "http://35.169.247.105:8080/usuario/"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build();
    }
}