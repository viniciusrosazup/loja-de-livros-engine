package br.com.example.livro.core.ports

import br.com.example.livro.database.entity.Livro
import br.com.example.livro.entrypoint.dto.LivroDto

interface LivroServicePort {
    fun livroMessage(livro: Livro): LivroDto
}