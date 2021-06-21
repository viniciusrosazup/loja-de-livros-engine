package br.com.example.livro.core.mapper

import br.com.example.livro.core.model.Livro
import br.com.example.livro.database.entity.LivroEntity
import br.com.example.livro.entrypoint.dto.LivroDto
import java.util.stream.Collectors

class LivroConverter {
    companion object {
        fun listOfLivroEntityToLivroDto(listOfBooksEntity: MutableList<Livro>?) =
            listOfBooksEntity?.stream()?.map { livro ->
                LivroDto(
                    livro.id,
                    livro.autor,
                    livro.description,
                    livro.numero_de_paginas,
                    livro.isbn,
                    livro.preco
                )
            }?.collect(Collectors.toList())


        fun LivroEntityToDto(livro: br.com.example.livro.database.entity.LivroEntity) = LivroDto(
            livro.id,
            livro.autor,
            livro.description,
            livro.numero_de_paginas,
            livro.isbn,
            livro.preco
        )

        fun LivroEntitytoLivro(livroEntity: LivroEntity): Livro = Livro(
            livroEntity.id,
            livroEntity.autor,
            livroEntity.description,
            livroEntity.numero_de_paginas,
            livroEntity.isbn,
            livroEntity.preco
        )

        fun LivroEntityListToLivroList(livro: MutableList<LivroEntity>?) = livro?.stream()?.map { livro ->
            Livro(livro.id, livro.autor, livro.description, livro.numero_de_paginas, livro.isbn, livro.preco)
        }?.collect(Collectors.toList())

    }
}
