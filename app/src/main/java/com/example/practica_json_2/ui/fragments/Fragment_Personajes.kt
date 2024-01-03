package com.example.practica_json_2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.practica_json_2.R
import com.example.practica_json_2.data.model.Personajes
import com.example.practica_json_2.databinding.FragmentPersonajesBinding
import com.example.practica_json_2.ui.MyAdapter
import com.example.practica_json_2.ui.MyViewModel

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException
import java.io.InputStream


class Fragment_Personajes : Fragment() {

    private var _binding: FragmentPersonajesBinding? = null
    private val binding get() = _binding!!

    val charModel by activityViewModels<MyViewModel>(){

        MyViewModel.MyViewModelFactory(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPersonajesBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerview

        val llm = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        recyclerView.layoutManager = llm

        val adapter = MyAdapter(object : MyAdapter.OnPersonajeClickListener {
            override fun onClick(personaje: Personajes) {
                charModel.elegirPersonaje(personaje)
                findNavController().navigate(R.id.action_fragment_Personajes_to_fragment_Informacion)
            }

        })

        recyclerView.adapter = adapter

        charModel.cargar()

        charModel.listaLiveData.observe(viewLifecycleOwner){

            adapter.update(it)

        }


    }


}