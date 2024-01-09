package com.example.mysql

import io.ktor.server.util.*
import org.ktorm.database.Database

object DbConnection {
    private val db: Database? = null

    fun getDatabaseInstance():Database{
        return db
            ?: Database.connect(
                url ="jdbc:mysql://localhost:3306/ktorm",
                driver = "com.mysql.cj.jdbc:Driver",
                user = "",
                password = ""
            )
    }
}