package br.com.example.livro.entrypoint.dto

import br.com.example.livro.database.entity.LivroEntity
import java.util.UUID

data class LivroDto(
    val id: UUID? = null,
    val autor: String = "",
    val description: String = "",
    val numero_de_paginas: String = "",
    val isbn: String = "",
    val preco: Double = 0.0
) {
    fun toModel(): LivroEntity {
        return LivroEntity(
            id, autor, description, numero_de_paginas, isbn, preco
        )

    }

}
