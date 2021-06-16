package br.com.example

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "loja-de-livros",
        version = "0.0",
    )
)
object Aplication {

}

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("br.com.example")
        .start()
}

