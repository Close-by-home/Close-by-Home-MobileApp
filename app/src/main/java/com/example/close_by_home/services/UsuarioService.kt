package com.example.close_by_home.services

import com.example.close_by_home.models.Usuario
import com.example.close_by_home.models.UsuarioLoginDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuarioService {
    @GET("/usuario")
    fun list(): Call<List<Usuario>>

    @GET("/usuario/{id}")
    fun getById(
        @Path("id") id: String
    ): Call<Usuario>
    @POST("/usuario/logar")
    fun login(@Body userData: UsuarioLoginDto): Call<UsuarioLoginDto>
}
