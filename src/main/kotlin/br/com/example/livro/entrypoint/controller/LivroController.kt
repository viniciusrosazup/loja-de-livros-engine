package br.com.example.livro.entrypoint.controller

import br.com.example.livro.core.mapper.LivroConverter
import br.com.example.livro.core.ports.LivroServicePort
import br.com.example.livro.entrypoint.dto.LivroDto
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*

@Controller("api/livros")
class LivroController(private val service: LivroServicePort) {

    @Get
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun buscaLivros(): MutableList<LivroDto> {
        return LivroConverter.listOfLivroEntityToLivroDto(service.findLivroList())
    }

    @Get("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun buscaLivroPorId(@PathVariable("id") id: UUID): LivroDto {
        return LivroConverter.LivroEntityToDto(service.findByLivroId(id))
    }


}