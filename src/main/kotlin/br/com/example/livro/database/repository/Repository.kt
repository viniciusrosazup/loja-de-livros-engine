package br.com.example.livro.database.repository

import br.com.example.livro.database.entity.Livro
import javax.inject.Singleton

@Singleton
interface Repository {
    fun createBook(livro: Livro): Livro
    fun buscaLivro(): MutableList<Livro>

}