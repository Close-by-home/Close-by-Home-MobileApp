package com.example.close_by_home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.close_by_home.R
import com.example.close_by_home.adapters.FuncionarioAdapter
import com.example.close_by_home.adapters.ServicoAdapter
import com.example.close_by_home.models.Funcionario
import com.example.close_by_home.models.FuncionarioEndPoint
import com.example.close_by_home.models.Servico
import com.example.close_by_home.models.Usuario
import com.example.close_by_home.rest.Rest
import com.example.close_by_home.services.FuncionarioService
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import javax.security.auth.callback.Callback

class HomeFragment : Fragment() {

    lateinit var servicoAdapter: ServicoAdapter
    lateinit var funcionarioAdapter: FuncionarioAdapter

    private val servicos = mutableListOf<Servico>()
    private val funcionarios = mutableListOf<Funcionario>()
    private val retrofit = Rest.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colecoes : RecyclerView = view.findViewById(R.id.rvFuncionarios)
        val pickServico : RecyclerView = view.findViewById(R.id.rvIconsServicos)
        servicoAdapter = ServicoAdapter(servicos, view.context)
        funcionarioAdapter = FuncionarioAdapter(funcionarios, view.context)

        val servicoLayout = LinearLayoutManager(view.context)
        val layoutManager = LinearLayoutManager(view.context)

        servicoLayout.setOrientation(RecyclerView.HORIZONTAL)

        pickServico.layoutManager = servicoLayout
        pickServico.adapter = servicoAdapter
        colecoes.layoutManager = layoutManager
        colecoes.adapter = funcionarioAdapter

        preencherServicos()
//        preencherLista()
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

    private fun preencherServicos() {

        servicos.clear()
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))

        funcionarioAdapter.notifyDataSetChanged()

    }

}
