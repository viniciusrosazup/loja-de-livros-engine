package br.com.example.livro.entrypoint.dto

import br.com.example.livro.database.entity.LivroEntity
import java.util.*

class LivroDto(
    val id:UUID,
    val autor: String,
    val description: String,
    val numero_de_paginas: String,
    val isbn: String,
    val preco: Double
) {
    fun toModel(): LivroEntity {
        return LivroEntity(
            id, autor, description, numero_de_paginas, isbn, preco
        )

    }

}
