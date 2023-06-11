package com.example.close_by_home.rest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.close_by_home.R
import com.example.close_by_home.databinding.ActivityMudarSenhaBinding

class MudarSenhaActivity : AppCompatActivity() {
    private lateinit var codigo: EditText
    private lateinit var email: EditText

    private val binding by lazy {
        ActivityMudarSenhaBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        codigo = binding.etCodigo
        email = binding.etEmail

        binding.btnVoltar.setOnClickListener{
            voltarMain()
        }
        binding.btnMudarSenha.setOnClickListener {
            mudarSenha()
        }
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
            Toast.makeText(baseContext, "Teste Testado", Toast.LENGTH_LONG).show()
        }
    }

    private fun voltarMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}