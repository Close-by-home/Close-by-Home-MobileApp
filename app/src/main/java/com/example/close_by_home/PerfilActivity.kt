package com.example.close_by_home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.close_by_home.databinding.ActivityPerfilBinding
import com.example.close_by_home.models.Funcionario
import com.example.close_by_home.models.FuncionarioEndPoint
import com.example.close_by_home.models.Perfil
import com.example.close_by_home.models.UsuarioLoginDto
import com.example.close_by_home.rest.HomeActivity
import com.example.close_by_home.rest.Rest
import com.example.close_by_home.services.FuncionarioService
import com.example.close_by_home.services.UsuarioService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerfilActivity : AppCompatActivity() {

    private val retrofit = Rest.getInstance()

    private val binding by lazy {
        ActivityPerfilBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnVoltar.setOnClickListener{
            voltarPerfil()
        }

        getDadosPerfil()
    }

    private fun getDadosPerfil() {
        retrofit.create(UsuarioService::class.java)
            .pegarUser(UsuarioLoginDto(
                codigoCondominio = "09520000",
                email = "felipe.andrade@bandtec.com.br",
                senha = "123456"
            ))
            .enqueue(object: Callback<Perfil> {
                override fun onResponse(
                    call: Call<Perfil>,
                    response: Response<Perfil>
                ) {
                    binding.tvNome.text = response.body()?.nome
                    binding.tvBloco.text = response.body()?.bloco
                    binding.tvCondigo.text = response.body()?.codigoCondominio
                    binding.tvEmail.text = response.body()?.email
                    binding.tvNumero.text = response.body()?.telefone
                }

                override fun onFailure(call: Call<Perfil>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }

    private fun voltarPerfil() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}