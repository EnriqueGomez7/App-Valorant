package com.example.practica_json_2.data.model


data class Personajes(

    val displayName: String?,

    val description: String?,

    val displayIcon: String?,

    val fullPortrait: String?,

    val background: String?,

    val isPlayableCharacter: Boolean?,

    val role: Role?,

    val abilities: List<Abilities>

)
