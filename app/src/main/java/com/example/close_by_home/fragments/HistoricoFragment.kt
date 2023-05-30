package com.example.close_by_home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.close_by_home.R
import com.example.close_by_home.adapters.FuncionarioAdapter
import com.example.close_by_home.models.Funcionario

class HistoricoFragment : Fragment() {

    lateinit var funcionarioAdapter: FuncionarioAdapter

    private val funcionarios = mutableListOf<Funcionario>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historico, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val colecoes : RecyclerView = view.findViewById(R.id.rvFuncionarios)
        funcionarioAdapter = FuncionarioAdapter(funcionarios, view.context)

        val layoutManager = LinearLayoutManager(view.context)

        colecoes.layoutManager = layoutManager
        colecoes.adapter = funcionarioAdapter

        preencherLista()
    }

    private fun preencherLista() {

        funcionarios.clear()
        funcionarios.add(Funcionario(1,"Cezar Melo", "Jardineiro", "11987436574", "http://pudim.com.br/pudim.jpg"))
        funcionarios.add(Funcionario(2, "Eloisa Ribeiro", "Manicure", "11948763028", "http://pudim.com.br/pudim.jpg"))
                  funcionarios.add(Funcionario(3, "Debora", "Baba", "11923876437", "https://stackoverflow.co/img/product/teams/teams-home-hero.svg"))

        funcionarioAdapter.notifyDataSetChanged()
    }
}