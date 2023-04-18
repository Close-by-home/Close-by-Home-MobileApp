package com.example.close_by_home.models

data class Condominio (
    val id : Int ,
    val cnpj : String ,
    val codigoCondominio : String ,
    val cep : String ,
    val telefone : String ,
    val usuarios: List<Usuario>,
    val numero : Int ,
    val quatidadeDeBlocos : Int ,
    val sindico : String ,
    val emailSindico : String ,
    )
