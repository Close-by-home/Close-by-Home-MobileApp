package com.example.close_by_home.models

data class Usuario (
    val id: Int,
    val cpf: String,
    val codigoCondominio: Condominio,
    val bloco: String,
    val email: String,
    val telefone: String,
    val nome: String,
    val senha: String,
    val funcionario: Boolean,
    val sexo: String,
    val imagem: String,
    val func: Funcionario,
    )
