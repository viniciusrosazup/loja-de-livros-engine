package br.com.example.livro.core.model

import io.micronaut.core.annotation.Introspected
import java.util.*


@Introspected
class Livro(
    val id: UUID,
    val autor: String,
    val description: String,
    val numero_de_paginas: String,
    val isbn: String,
    val preco: Double
) {

}