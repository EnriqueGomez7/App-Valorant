package com.example.practica_json_2.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practica_json_2.data.Repository
import com.example.practica_json_2.data.model.Personajes

class MyViewModel(val context: Context) : ViewModel() {

    private val repository = Repository(context)

    val listaLiveData = MutableLiveData<List<Personajes>>()

    val personajeSeleccionado = MutableLiveData<Personajes>()

    fun cargar(){

        listaLiveData.value = repository.cargarlista()

    }

    fun elegirPersonaje(personajes: Personajes) {

        personajeSeleccionado.value = personajes

    }



    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }

    }
}