package com.example.practica_json_2.data

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.practica_json_2.data.model.Personajes
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException
import java.io.InputStream

class Repository (val context: Context) {

    fun cargarlista(): List<Personajes>? {

        val json = getJsonFromAsset2("valorant.json")

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

        val newType = Types.newParameterizedType(List::class.java, Personajes::class.java)

        val jsonAdapter = moshi.adapter<List<Personajes>>(newType)

        val miLista = jsonAdapter.fromJson(json)

        return miLista

    }

    private fun getJsonFromAsset2(ruta : String): String? {
        var jsonString: String? = null
        try {
            val inputStream: InputStream = context.assets.open(ruta)
            jsonString = inputStream.bufferedReader().use {
                it.readText()
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return jsonString
    }



}