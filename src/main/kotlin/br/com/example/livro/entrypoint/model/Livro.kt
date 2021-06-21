package br.com.example.livro.entrypoint.model

import java.util.UUID

data class Livro(
    val id: UUID? = null,
    val autor: String = "",
    val description: String = "",
    val numero_de_paginas: String = "",
    val isbn: String = "",
    val preco: Double = 0.0
) {

}
