package com.example.close_by_home.services

import com.example.close_by_home.models.FuncionarioEndPoint
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FuncionarioService {
    @GET("/funcionario/{codigoCondominio}")
    fun getByCodigo(
        @Path("codigoCondominio") codigoCondominio: String
    ): Call<List<FuncionarioEndPoint>>
}