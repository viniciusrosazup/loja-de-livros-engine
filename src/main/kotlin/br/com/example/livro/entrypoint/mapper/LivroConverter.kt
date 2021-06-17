package br.com.example.livro.entrypoint.mapper

import br.com.example.livro.entrypoint.dto.LivroDto
import java.util.stream.Collectors

class LivroConverter {
    companion object {
        fun listOfLivroEntityToLivroDto(listOfBooksEntity: MutableList<br.com.example.livro.database.entity.Livro>) =
            listOfBooksEntity.stream().map { livro ->
                LivroDto(
                    livro.id,
                    livro.autor,
                    livro.description,
                    livro.numero_de_paginas,
                    livro.isbn,
                    livro.preco
                )
            }.collect(Collectors.toList())


        fun LivroEntityToDto(livro: br.com.example.livro.database.entity.Livro?) = LivroDto(
            livro.id,
            livro.autor,
            livro.description,
            livro.numero_de_paginas,
            livro.isbn,
            livro.preco
        )

    }
}
