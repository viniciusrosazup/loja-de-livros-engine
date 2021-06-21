package br.com.example.livro.database.entity

import io.micronaut.core.annotation.Introspected
import java.util.UUID


@Introspected
data class LivroEntity(
    val id: UUID? = null,
    val autor: String = "",
    val description: String = "",
    val numero_de_paginas: String = "",
    val isbn: String = "",
    val preco: Double = 0.0
) {

}
