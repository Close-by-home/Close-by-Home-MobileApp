package com.example.close_by_home.rest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.close_by_home.R

class MudarSenha : AppCompatActivity() {

    private lateinit var codigo: EditText
    private lateinit var email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mudar_senha)
        codigo = findViewById(R.id.etCodigo)
        email = findViewById(R.id.etEmail)
    }

    private fun camposValidos(): Boolean {

        if(codigo.text.isNullOrEmpty()){
            this.codigo.error = "Valor inválido para o código"
            return false
        }else if(codigo.text.isNullOrEmpty()){
            this.email.error = "Valor inválido para o e-mail"
            return false
        }

        return true;
    }
    private fun mudarSenha(){
        if(camposValidos()){

        }
    }
}