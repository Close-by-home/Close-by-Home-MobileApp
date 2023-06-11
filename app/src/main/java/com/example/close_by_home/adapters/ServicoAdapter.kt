package com.example.close_by_home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.close_by_home.R
import com.example.close_by_home.models.Servico
import com.squareup.picasso.Picasso
import java.io.File

class ServicoAdapter (
    val lista: MutableList<Servico>,
    val context: Context
) : RecyclerView.Adapter<ServicoAdapter.ServicoViewHolder>() {

    class ServicoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.tvTextIcon)
        val imagem: ImageView = itemView.findViewById(R.id.ivIconTrab)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ServicoAdapter.ServicoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.res_job_item,
            parent, false)
        return ServicoViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ServicoAdapter.ServicoViewHolder,
        position: Int) {
        val item = lista.get(position)
        holder.nome.text = item.texto
//        Picasso.with(context).load(item.img).into(holder.imagem)
        Picasso.with(context).load(item.img).into(holder.imagem)
        }

    override fun getItemCount(): Int {
        return lista.size;
    }
}