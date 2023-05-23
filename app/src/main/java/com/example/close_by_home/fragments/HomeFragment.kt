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
import com.example.close_by_home.models.Usuario

class HomeFragment : Fragment() {

    lateinit var funcionarioAdapter: FuncionarioAdapter

    private val funcionarios = mutableListOf<Funcionario>()

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
        funcionarioAdapter = FuncionarioAdapter(funcionarios, view.context)
        val layoutManager = LinearLayoutManager(view.context)

        colecoes.layoutManager = layoutManager
        colecoes.adapter = funcionarioAdapter

        preencherLista()
    }

    private fun preencherLista() {

        funcionarios.clear()
        funcionarios.add(Funcionario(1, "aaa", "ssss", 1.0, "https://guides.codepath.com/images/logos/codepath.svg?1684262685"))
        funcionarios.add(Funcionario(2, "bb b b b b", "padeiro", 1.0, "http://pudim.com.br/pudim.jpg"))
        funcionarios.add(Funcionario(3, "lady", "cantor", 1.0, "https://stackoverflow.co/img/product/teams/teams-home-hero.svg"))

        funcionarioAdapter.notifyDataSetChanged()
    }

}
