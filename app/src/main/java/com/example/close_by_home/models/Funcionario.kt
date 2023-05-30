package com.example.close_by_home.models

data class Funcionario (
    val id : Int ,
    val nomeUsuario: String,
    val nomeServico: String,
   // val valorMinimo: Double,
    val imagem: String,
    val contato: String,
   // val agenda : List<Agenda>,
    // val data : List<Data>,
//    val usuario: Usuario,
    ) : java.io.Serializable
