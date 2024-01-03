package com.example.practica_json_2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.practica_json_2.R
import com.example.practica_json_2.databinding.FragmentInformacionBinding
import com.example.practica_json_2.ui.MyViewModel

class Fragment_Informacion : Fragment() {

    private var _binding: FragmentInformacionBinding? = null

    private val binding get() = _binding!!

    val charModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInformacionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charModel.personajeSeleccionado.observe(viewLifecycleOwner){

            binding.nombreInformacion.text = it.displayName

            Glide.with(binding.root.context).load(it.fullPortrait).into(binding.fotoInformacion)

            binding.rolInformacion.text = it.role?.displayName

            Glide.with(binding.root.context).load(it.role?.displayIcon).into(binding.fotoRol)

            Glide.with(binding.root.context).load(it.abilities[0].displayIcon).into(binding.habilidad1)

            it.abilities

            Glide.with(binding.root.context).load(it.abilities[1].displayIcon).into(binding.habilidad2)

            Glide.with(binding.root.context).load(it.abilities[2].displayIcon).into(binding.habilidad3)

            Glide.with(binding.root.context).load(it.abilities[3].displayIcon).into(binding.habilidad4)

            binding.lore.text = it.description

        }
    }


}