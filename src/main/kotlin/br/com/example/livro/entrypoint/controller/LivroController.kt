package br.com.example.livro.entrypoint.controller

import br.com.example.livro.database.entity.Livro
import br.com.example.livro.entrypoint.dto.LivroDto
import br.com.example.livro.database.repository.Repository
import br.com.example.livro.entrypoint.service.LivroService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.*

@Controller("api/livros")
class LivroController(private val service: LivroService, private val repository: Repository) {

    @Post("cadastro")
    @Produces(APPLICATION_JSON)
    fun createLivro(@Body request: LivroDto): Livro {
        val livro = request.toModel()
        service.send(
            Livro(
                livro.id,
                livro.autor,
                livro.description,
                livro.numero_de_paginas,
                livro.isbn,
                livro.preco
            )
        )

        return livro


    }


    @Get("/buscaLivros")
    fun buscaLivros(@Body request: LivroDto): HttpResponse<Any> {
        val livro = request.toModel()
        val livros = service.findBooks(livro = livro);
        return HttpResponse.ok(livros)
    }


}