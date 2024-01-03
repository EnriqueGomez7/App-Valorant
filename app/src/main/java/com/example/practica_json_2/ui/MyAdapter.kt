package com.example.practica_json_2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica_json_2.data.model.Personajes
import com.example.practica_json_2.databinding.VistaCeldaBinding

class MyAdapter(val listener: OnPersonajeClickListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    interface OnPersonajeClickListener {
        fun onClick(personaje: Personajes)

    }

    private val dataList = ArrayList<Personajes>()

    inner class MyViewHolder(val binding: VistaCeldaBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(personajes: Personajes) {

            Glide.with(binding.root.context).load(personajes.displayIcon).into(binding.foto)

            Glide.with(binding.root.context).load(personajes.role?.displayIcon).into(binding.fotoRol)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = VistaCeldaBinding.inflate(layoutInflater, parent, false)

        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return dataList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val personajes = dataList[position]

        holder.itemView.setOnClickListener {
            listener.onClick(personajes)
        }


        holder.binding.nombre.text = personajes.displayName

        holder.bind(personajes)

    }

    fun update(list: List<Personajes>){

        dataList.clear()

        dataList.addAll(list)

        notifyDataSetChanged()

    }
}
