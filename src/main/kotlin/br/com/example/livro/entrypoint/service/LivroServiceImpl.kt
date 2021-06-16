package br.com.example.livro.entrypoint.service

import br.com.example.livro.database.entity.Livro
import br.com.example.livro.database.repository.Repository
import javax.inject.Singleton

@Singleton
class LivroServiceImpl(private val repository: Repository) : LivroService {
    override fun send(livro: Livro): Livro {
        return repository.createBook(livro)
    }

    override fun findBooks(): MutableList<Livro> {
        return repository.buscaLivro()
    }
}