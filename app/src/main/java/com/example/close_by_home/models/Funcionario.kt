package com.example.close_by_home.models

data class Funcionario (
    val id : Int ,
    val nomeServico: String,
    val valorMinimo: Double,
    val agenda : List<Agenda>,
    val data : List<Data>,
    val idUsuario: Usuario,
    )
