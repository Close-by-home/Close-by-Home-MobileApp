package com.example.close_by_home.models

import java.time.LocalDateTime

data class Agenda (
    val id : Int ,
    val func: Funcionario,
    val user: Usuario,
    val data: LocalDateTime
    )
