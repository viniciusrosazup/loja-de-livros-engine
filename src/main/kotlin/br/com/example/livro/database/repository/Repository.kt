package br.com.example.livro.database.repository

import br.com.example.livro.database.entity.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
interface Repository {
    fun buscaLivro(): MutableList<Livro>
    fun buscaLivroPorId(id: UUID): Livro?

}