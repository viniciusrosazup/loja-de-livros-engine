package br.com.example.livro.producer.controller

import br.com.example.livro.database.entity.Livro
import br.com.example.livro.entrypoint.controller.LivroController
import br.com.example.livro.entrypoint.dto.LivroDto
import io.kotest.core.spec.style.AnnotationSpec

import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import java.util.*


@MicronautTest
class LivroControllerTest : AnnotationSpec(){
    @InjectMockKs
    lateinit var livroController: LivroController

    @MockK
    lateinit var livroService: LivroService
    lateinit var livroDto: LivroDto
    lateinit var livro: Livro

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        livroDto = LivroDto(
            id = UUID.randomUUID(),
            autor = "Vinicius Cruz da Rosa",
            description = "Um livro sobre um lugar bonito preso nos sonhos de um rapaz comum",
            numero_de_paginas = "111",
            isbn = "282901930",
            preco = 89.9
        )

        livro= Livro(
            livroDto.id,
            livroDto.autor,
            livroDto.description,
            livroDto.numero_de_paginas,
            livroDto.isbn,
            livroDto.preco
        )
    }


    @Test
    fun `request product with sucess`() {
        every { livroService.send(any()) } returns livro
        val result = livroController.createLivro(livroDto)
        result.id shouldBe livro.id
    }




}
