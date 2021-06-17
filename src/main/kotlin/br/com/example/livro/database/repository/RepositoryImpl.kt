package br.com.example.livro.database.repository

import br.com.example.livro.database.entity.Livro
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class RepositoryImpl(private val session: CqlSession) : Repository {
    override fun buscaLivro(): MutableList<Livro> {
        val rows = session.execute(
            SimpleStatement.newInstance(
                "SELECT * FROM LIVRO"
            )
        ).toList()
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


    override fun buscaLivroPorId(id: UUID): Livro? {
        try {
            val selectResult = session.execute(
                SimpleStatement.newInstance("SELECT * FROM livro.Livro WHERE id = ? LIMIT 100000", id)
            )

            val livro = selectResult.map {
                Livro(
                    id = it.getUuid("id")!!,
                    autor = it.getString("autor")!!,
                    description = it.getString("description")!!,
                    numero_de_paginas = it.getString("numero_de_paginas")!!,
                    isbn = it.getString("isbn")!!,
                    preco = it.getDouble("preco")!!
                )
            }.firstOrNull()

            return livro

        } catch (error: IllegalAccessError) {
            throw IllegalAccessError()
        }
    }
}