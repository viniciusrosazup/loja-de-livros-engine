package br.com.example.livro.database.repository

import br.com.example.livro.database.entity.Livro
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import javax.inject.Singleton

@Singleton
class RepositoryImpl(private val session: CqlSession) : Repository {
    override fun createBook(livro: Livro): Livro {
        val livro = Livro(
            livro.id,
            livro.autor,
            livro.description,
            livro.numero_de_paginas,
            livro.isbn,
            livro.preco
        )

        session.execute(
            SimpleStatement.newInstance(
                "INSERT INTO livro.Livro(id,autor,description,numero_de_paginas,isbn,preco) VALUES(?,?,?,?,?,?)",
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

    override fun buscaLivro(): MutableList<Livro> {
        val rows = session.execute("SELECT * FROM LIVRO").toList()
        val livros: MutableList<Livro> = mutableListOf()
        for (row in rows) {
            val id = row.getUuid(CqlIdentifier.fromCql("id"))!!
            val autor = row.getString(CqlIdentifier.fromCql("autor"))!!
            val description = row.getString(CqlIdentifier.fromCql("description"))!!
            val numero_de_paginas = row.getString(CqlIdentifier.fromCql("numero_de_paginas"))!!
            val isbn = row.getString(CqlIdentifier.fromCql("isbn"))!!
            val preco = row.getDouble(CqlIdentifier.fromCql("preco"))!!

            livros.add(
                Livro(
                    id,
                    autor,
                    description,
                    numero_de_paginas,
                    isbn,
                    preco

                )
            )
        }

        return livros

    }
}