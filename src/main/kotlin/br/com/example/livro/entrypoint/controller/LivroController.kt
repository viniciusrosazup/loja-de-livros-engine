package br.com.example.livro.entrypoint.controller

import br.com.example.livro.core.mapper.LivroConverter
import br.com.example.livro.entrypoint.dto.LivroDto
import br.com.example.livro.database.repository.Repository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("api/livros")
class LivroController(private val repository: Repository) {

    @Get
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun buscaLivros(): MutableList<LivroDto> {
        return LivroConverter.listOfLivroEntityToLivroDto(repository.buscaLivro())
    }

//    @Get("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    fun buscaLivroPorId(): LivroDto {
//
//    }
//

}