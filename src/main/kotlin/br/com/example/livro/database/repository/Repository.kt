package br.com.example.livro.database.repository

import br.com.example.livro.database.entity.LivroEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface Repository {
    fun buscaLivro(): MutableList<LivroEntity>
    fun buscaLivroPorId(id: UUID): LivroEntity?

}