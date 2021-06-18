package br.com.example.livro.core.service

import br.com.example.livro.core.mapper.LivroConverter
import br.com.example.livro.core.model.Livro
import br.com.example.livro.core.ports.LivroRepositoryPort
import br.com.example.livro.core.ports.LivroServicePort
import br.com.example.livro.database.entity.LivroEntity
import java.util.*

class LivroService(private val repository: LivroRepositoryPort) : LivroServicePort {
    override fun findLivroList(): MutableList<Livro>? {
        return LivroConverter.LivroEntityListToLivroList(repository.findLivroList())
    }

    override fun findByLivroId(id: UUID): Livro {
        return LivroConverter.LivroEntitytoLivro(repository.findByLivroId(id)!!)
    }
}