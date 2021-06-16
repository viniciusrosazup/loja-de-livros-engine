package br.com.example.livro.entrypoint.service

import br.com.example.livro.database.entity.Livro


interface LivroService {
    fun send(livro: Livro): Livro
    fun findBooks(): MutableList<Livro>
}