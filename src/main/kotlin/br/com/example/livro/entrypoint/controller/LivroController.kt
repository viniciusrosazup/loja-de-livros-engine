package br.com.example.livro.entrypoint.controller

import br.com.example.livro.entrypoint.mapper.LivroConverter
import br.com.example.livro.entrypoint.dto.LivroDto
import br.com.example.livro.database.repository.Repository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*

@Controller("api/livros")
class LivroController(private val repository: Repository) {

    @Get
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun buscaLivros(): MutableList<LivroDto> {
        return LivroConverter.listOfLivroEntityToLivroDto(repository.buscaLivro())
    }

    @Get("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun buscaLivroPorId(@PathVariable("id") id: UUID): LivroDto {
        return LivroConverter.LivroEntityToDto(repository.buscaLivroPorId(id))

    }


}