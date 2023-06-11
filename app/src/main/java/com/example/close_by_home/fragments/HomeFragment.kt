package com.example.close_by_home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.close_by_home.R
import com.example.close_by_home.adapters.FuncionarioAdapter
import com.example.close_by_home.adapters.ServicoAdapter
import com.example.close_by_home.models.Funcionario
import com.example.close_by_home.models.Servico
import com.example.close_by_home.models.Usuario

class HomeFragment : Fragment() {

    lateinit var servicoAdapter: ServicoAdapter
    lateinit var funcionarioAdapter: FuncionarioAdapter

    private val servicos = mutableListOf<Servico>()
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
        preencherLista()
    }

    private fun preencherServicos() {

        servicos.clear()
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
        servicos.add(Servico(R.drawable.ferramenta, "Pedreiro"))
    }

    private fun preencherLista() {

        funcionarios.clear()
        funcionarios.add(Funcionario(1, "Julio Cézar", "Mecânico","https://guides.codepath.com/images/logos/codepath.svg?1684262685", "11968579719"))
        funcionarios.add(Funcionario(2, "Ana Júlia", "Babá","https://guides.codepath.com/images/logos/codepath.svg?1684262685", "11934951010"))
        funcionarios.add(Funcionario(3, "Robson Mendes", "Serviços Gerais","https://guides.codepath.com/images/logos/codepath.svg?1684262685", "11940028922"))
        funcionarios.add(Funcionario(4, " Mendes", "Cuidador cães","https://guides.codepath.com/images/logos/codepath.svg?1684262685", "11940028922"))

        funcionarioAdapter.notifyDataSetChanged()
    }

}
