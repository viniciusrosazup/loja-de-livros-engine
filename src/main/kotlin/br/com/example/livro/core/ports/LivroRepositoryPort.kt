package br.com.example.livro.core.ports

import br.com.example.livro.database.entity.LivroEntity
import java.util.*

interface LivroRepositoryPort {
    fun findLivroList(): MutableList<LivroEntity>?
    fun findByLivroId(id: UUID): LivroEntity
}