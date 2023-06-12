package com.example.close_by_home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.close_by_home.R
import com.example.close_by_home.adapters.FuncionarioAdapter
import com.example.close_by_home.models.Funcionario
import com.example.close_by_home.models.FuncionarioEndPoint
import com.example.close_by_home.rest.Rest
import com.example.close_by_home.services.FuncionarioService
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate

class ContratarFragment : Fragment() {

    lateinit var funcionarioAdapter: FuncionarioAdapter

    private val funcionarios = mutableListOf<Funcionario>()
    private val retrofit = Rest.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contratar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val colecoes : RecyclerView = view.findViewById(R.id.rvFuncionarios)
        funcionarioAdapter = FuncionarioAdapter(funcionarios, view.context)

        val layoutManager = LinearLayoutManager(view.context)

        colecoes.layoutManager = layoutManager
        colecoes.adapter = funcionarioAdapter

        getFuncionarios()
    }

    private fun getFuncionarios() {
        retrofit.create(FuncionarioService::class.java)
            .getByCodigo("09520000")
            .enqueue(object: retrofit2.Callback<List<FuncionarioEndPoint>> {
                override fun onResponse(
                    call: Call<List<FuncionarioEndPoint>>,
                    response: Response<List<FuncionarioEndPoint>>
                ) {
                    funcionarios.clear()
                    response.body()!!.iterator()?.forEach {funcionario ->
                        funcionarios.add(
                            Funcionario(
                                1,
                                funcionario.nomeUsuario,
                                funcionario.nomeServico,
                                funcionario.emailUsuario,
                                LocalDate.now().toString()
                            ))
                    }
                    funcionarioAdapter.notifyDataSetChanged()

//                    Toast.makeText(requireContext(), "foi", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<List<FuncionarioEndPoint>>, t: Throwable) {
                    Toast.makeText(requireContext(), "não foi", Toast.LENGTH_LONG).show()
                }
            })
    }
}
