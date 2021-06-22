package br.com.example.livro.core.ports

import br.com.example.livro.core.model.Livro
import br.com.example.livro.database.entity.LivroEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface LivroServicePort {
    fun findLivroList(): MutableList<Livro>?
    fun findByLivroId(id: UUID): Livro
}