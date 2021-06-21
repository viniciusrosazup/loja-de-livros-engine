package br.com.example.livro.database.repository

import br.com.example.livro.database.entity.LivroEntity
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class RepositoryImpl(private val session: CqlSession) : Repository {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun buscaLivro(): MutableList<LivroEntity> {
        val rows = session.execute(
            SimpleStatement.newInstance(
                "SELECT * FROM LIVRO"
            )
        ).toList()
        val livros: MutableList<LivroEntity> = mutableListOf()
        for (row in rows) {
            val id = row.getUuid(CqlIdentifier.fromCql("id"))!!
            val autor = row.getString(CqlIdentifier.fromCql("autor"))!!
            val description = row.getString(CqlIdentifier.fromCql("description"))!!
            val numero_de_paginas = row.getString(CqlIdentifier.fromCql("numero_de_paginas"))!!
            val isbn = row.getString(CqlIdentifier.fromCql("isbn"))!!
            val preco = row.getDouble(CqlIdentifier.fromCql("preco"))!!

            livros.add(
                LivroEntity(
                    id,
                    autor,
                    description,
                    numero_de_paginas,
                    isbn,
                    preco

                )
            )
        }

        logger.info("Livro buscado com sucesso do método {}", buscaLivro())

        return livros

    }


    override fun buscaLivroPorId(id: UUID): LivroEntity? {
        try {
            val selectResult = session.execute(
                SimpleStatement.newInstance("SELECT * FROM livro.Livro WHERE id = ? LIMIT 100000", id)
            )

            val livro = selectResult.map {
                LivroEntity(
                    id = it.getUuid("id")!!,
                    autor = it.getString("autor")!!,
                    description = it.getString("description")!!,
                    numero_de_paginas = it.getString("numero_de_paginas")!!,
                    isbn = it.getString("isbn")!!,
                    preco = it.getDouble("preco")!!
                )
            }.firstOrNull()

            logger.info("Livro buscado com sucesso do método {}", buscaLivroPorId(id))

            return livro

        } catch (error: IllegalAccessError) {
            throw IllegalAccessError()
        }
    }
}