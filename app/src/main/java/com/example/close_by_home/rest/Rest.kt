package com.example.close_by_home.rest
import  retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    private val BASE_URL = "https://closebyhome.zapto.org:8443"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build();
    }
}