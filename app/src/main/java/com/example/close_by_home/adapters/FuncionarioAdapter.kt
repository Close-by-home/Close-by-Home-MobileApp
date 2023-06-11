package com.example.close_by_home.adapters


import  com.example.close_by_home.R

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.close_by_home.models.Funcionario
import com.squareup.picasso.Picasso

class FuncionarioAdapter (
    val lista: MutableList<Funcionario>,
    val context: Context
) : RecyclerView.Adapter<FuncionarioAdapter.FuncionarioViewHolder>() {

        class FuncionarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nome: TextView = itemView.findViewById(R.id.tvNomePrestador)
            val servico: TextView = itemView.findViewById(R.id.tvNomeServico)
            val imagem: ImageView = itemView.findViewById(R.id.ivPestador)
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): FuncionarioAdapter.FuncionarioViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.res_card_job,
                parent, false)
            return FuncionarioViewHolder(itemView)
        }

        override fun onBindViewHolder(
            holder: FuncionarioAdapter.FuncionarioViewHolder,
            position: Int) {
            val item = lista.get(position)
            holder.nome.text = item.nomeUsuario
            holder.servico.text = item.nomeServico
            Picasso.with(context).load(item.imagem).into(holder.imagem);
        }

        override fun getItemCount(): Int {
            return lista.size
        }
}