package br.com.example.livro.core.mapper

import br.com.example.livro.core.model.Livro
import br.com.example.livro.entrypoint.dto.LivroDto
import java.util.stream.Collector
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

    }
}
