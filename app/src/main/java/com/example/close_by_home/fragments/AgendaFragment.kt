package com.example.close_by_home.fragments

import android.app.ActionBar.LayoutParams
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.close_by_home.PerfilActivity
import com.example.close_by_home.R
import com.example.close_by_home.adapters.FuncionarioAdapter
import com.example.close_by_home.databinding.ActivityMainBinding
import com.example.close_by_home.databinding.FragmentAgendaBinding
import com.example.close_by_home.models.Funcionario
import com.example.close_by_home.models.FuncionarioEndPoint
import com.example.close_by_home.rest.Rest
import com.example.close_by_home.services.FuncionarioService
import com.google.android.material.datepicker.MaterialDatePicker
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.util.Calendar

class AgendaFragment : Fragment(R.layout.fragment_agenda) {

    private lateinit var binding: FragmentAgendaBinding
    lateinit var funcionarioAdapter: FuncionarioAdapter
    private val datePicker by lazy { binding.pegarData }
    private var dataSelecionada = ""

    private val funcionarios = mutableListOf<Funcionario>()
    private val retrofit = Rest.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agenda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAgendaBinding.bind(view)
        binding.btnMudarData.setOnClickListener{
            openCalendario()
        }
        binding.ivPerfil.setOnClickListener(){
            irParaPerfil()
        }

        val colecoes : RecyclerView = view.findViewById(R.id.rvFuncionarios)
        funcionarioAdapter = FuncionarioAdapter(funcionarios, view.context)

        val layoutManager = LinearLayoutManager(view.context)

        dataSelecionada = LocalDate.now().toString()
        datePicker.init(datePicker.year, datePicker.month, datePicker.dayOfMonth) { view, year, monthOfYear, dayOfMonth ->
            val dayFormatted = String.format("%01d", dayOfMonth)
            val monthFormatted = String.format("%02d", monthOfYear + 1)
            val yearFormatted  = String.format("%02d", year)

            dataSelecionada = "$dayFormatted"
        }

        colecoes.layoutManager = layoutManager
        colecoes.adapter = funcionarioAdapter
    }

    private fun openCalendario() {

        val tamanhoLL = binding.llCalendario.layoutParams.height.toString()
        if(tamanhoLL == "281") {
            binding.llCalendario.layoutParams.height = LayoutParams.MATCH_PARENT
        } else {
            binding.llCalendario.layoutParams.height = 281
            getFuncionarios()
        }
//        Toast.makeText(this.requireContext(), dataSelecionada, Toast.LENGTH_LONG).show()
        binding.llCalendario.requestLayout()
    }

    private fun getFuncionarios() {
        retrofit.create(FuncionarioService::class.java)
            .getByCodigo("09520000")
            .enqueue(object: retrofit2.Callback<List<FuncionarioEndPoint>> {
                override fun onResponse(
                    call: Call<List<FuncionarioEndPoint>>,
                    response: Response<List<FuncionarioEndPoint>>
                ) {
                    binding.llCalendarioIcon.visibility = View.GONE
                    funcionarios.clear()
                    response.body()!!.iterator()?.forEach {funcionario ->
                        if(funcionario.cpf.toString().startsWith(dataSelecionada)) {
                            funcionarios.add(
                                Funcionario(
                                    1,
                                    funcionario.nomeUsuario,
                                    funcionario.nomeServico,
                                    funcionario.telefone,
                                    LocalDate.now().toString()
                                ))
                            }
                        }

                    funcionarioAdapter.notifyDataSetChanged()

                }

                override fun onFailure(call: Call<List<FuncionarioEndPoint>>, t: Throwable) {
                    Toast.makeText(requireContext(), "não foi", Toast.LENGTH_LONG).show()
                }
            })

    }

    private fun irParaPerfil() {
        val intent = Intent(this.requireActivity(), PerfilActivity::class.java)
        startActivity(intent)

    }
}