package com.example.close_by_home.rest
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import  retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    private val BASE_URL = "https://closebyhome.zapto.org:8443"

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request()
                val url = request.url().toString()
                println("URL da solicitação: $url")
                return chain.proceed(request)
            }
        })
        .build()

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build();
    }
}