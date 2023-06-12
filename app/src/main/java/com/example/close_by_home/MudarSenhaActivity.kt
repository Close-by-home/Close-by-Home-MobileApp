package com.example.close_by_home.rest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.close_by_home.R
import com.example.close_by_home.databinding.ActivityMudarSenhaBinding
import com.example.close_by_home.models.UsuarioLoginDto
import com.example.close_by_home.services.UsuarioService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MudarSenhaActivity : AppCompatActivity() {
    private lateinit var codigo: EditText
    private lateinit var email: EditText
    private val retrofit = Rest.getInstance()

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
            val intent = Intent(this, MainActivity::class.java)

            retrofit.create(UsuarioService::class.java)
                .enviarRecuperacaoSenha(codigo.text.toString(),email.text.toString())
                .enqueue(object: Callback<ResponseBody> {
                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        if (response.isSuccessful) {
                            print("A requisição funcionou: "+response)

                            if(response.code() == 202){
                                Toast.makeText(baseContext, "E-mail enviado", Toast.LENGTH_LONG).show()
                                startActivity(intent)
                                finish()

                            }else if(response.code() == 204){
                                Toast.makeText(
                                    baseContext,
                                    "Usuário não encontrado, e-mail ou código incorreto",
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                        } else {
                            print("A requisição não funcionou corretamente: $response")
                            Toast.makeText(
                                baseContext,
                                "Ocorreu um erro na requisição: "+response,
                                Toast.LENGTH_LONG
                            ).show()
                            print(response)
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        print("Ocorreu um erro ERRO:$t")
                        Toast.makeText(
                            baseContext,
                            t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }
    }

    private fun voltarMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}