package com.example.plugins

import com.example.data.mysql.entity.UserEntity
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDataBase() {
    val database = Database.connect(
        url ="jdbc:mysql://localhost:3306/ktorm",
//        driver = "com.mysql.cj.jdbc:Driver",
        user = "root",
        password = ""
    )

    transaction(database) {
        SchemaUtils.create(UserEntity)
    }

}