package com.example.close_by_home.models

data class LoginDto (
    val cpf: String,
    val bloco: String,
    val telefone: String,
    val email: String,
    val senha: String,
    val codigoCondominio: String,
)