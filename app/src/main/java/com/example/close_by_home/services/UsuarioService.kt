package com.example.close_by_home.services

import com.example.close_by_home.models.Usuario
import com.example.close_by_home.models.UsuarioLoginDto
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import javax.security.auth.callback.Callback

interface UsuarioService {
    @GET("/usuario")
    fun list(): Call<List<Usuario>>

    @GET("/usuario/{id}")
    fun getById(
        @Path("id") id: String
    ): Call<Usuario>
    @POST("/usuario/logar")
    fun login(@Body userData: UsuarioLoginDto): Call<UsuarioLoginDto>

    @POST("/usuario/email-recuperacao-senha/{codigoCondominio}/{email}")
    fun enviarRecuperacaoSenha(
        @Path("codigoCondominio") codigoCondominio: String,
        @Path("email") email: String
    ): Call<ResponseBody>
}
