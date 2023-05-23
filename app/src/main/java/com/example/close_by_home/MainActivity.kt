package com.example.close_by_home.rest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.close_by_home.R
import com.example.close_by_home.models.UsuarioLoginDto
import com.example.close_by_home.services.UsuarioService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var cod: EditText
    private lateinit var email: EditText
    private lateinit var senha: EditText
    private val retrofit = Rest.getInstance();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        cod = findViewById(R.id.etCodigo)
        email = findViewById(R.id.etEmail)
        senha = findViewById(R.id.etSenha)
    }

    private fun camposValidos(): Boolean {
        var valido: Boolean = true

        if(cod.text.isNullOrEmpty()){
            valido = false
            this.cod.error = "O codigo não pode ser vazio!"
        }else if(cod.text.length > 15){
            valido = false
            this.cod.error = "O codigo inserido possui um tamanho invalido"
        }

        if(email.text.isNullOrEmpty()){
            valido = false
            this.email.error = "O e-mail não pode ser vazio!"
        }else if(email.text.length > 50 || email.text.length < 8){
            valido = false
            this.email.error = "O e-mail inserido possui um tamanho invalido"
        }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(this.email.text).matches()){
            valido = false
            this.email.error = "O e-mail inserido possui um formato invalido"
        }

        if(senha.text.isNullOrEmpty()){
            valido = false
            this.senha.error = "A senha inserida não pode ser vazia!"
        }else if(senha.text.length > 12 || senha.text.length < 4){
            valido = false
            this.senha.error = "A senha inserida possui um tamanho invalido"
        }

        return valido;
    }
    fun logar(view: View) {
        val intent = Intent(this, ActivityHome::class.java)
        startActivity(intent)
        finish()

//        if(camposValidos()){
//            val intent = Intent(this, ActivityHome::class.java)
//            val userInfo = UsuarioLoginDto(
//                codigoCondominio = cod.text.toString(),
//                email = email.text.toString(),
//                senha = senha.text.toString())
//            println(userInfo)
//            retrofit.create(UsuarioService::class.java)
//                .login(userInfo)
//                .enqueue(object : Callback<UsuarioLoginDto> {
//                    override fun onResponse(call: Call<UsuarioLoginDto>, response: Response<UsuarioLoginDto>) {
//                        if (response.isSuccessful) {
//                            print("A requisição funcionou: "+response)
//
//                            if(response.code() == 200){
//                                startActivity(intent);
//                                finish();
//                            }else if(response.code() == 204){
//                                Toast.makeText(
//                                    baseContext,
//                                    "Login incorreto",
//                                    Toast.LENGTH_LONG
//                                ).show()
//                            }
//
//                        } else {
//                            print("A requisição não funcionou corretamente: $response")
//                            Toast.makeText(
//                                baseContext,
//                                "Ocorreu um erro na requisição",
//                                Toast.LENGTH_LONG
//                            ).show()
//                            print(response)
//                        }
//                    }
//
//                    override fun onFailure(call: Call<UsuarioLoginDto>, t: Throwable) {
//                        print("ERRO:$t")
//                        Toast.makeText(
//                            baseContext,
//                            t.message,
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                })
//        }
    }
}