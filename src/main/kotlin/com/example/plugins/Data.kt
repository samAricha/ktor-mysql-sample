package com.example.plugins

import com.example.data.mysql.migrations.migration1
import com.example.data.mysql.seeders.personDemoData
import com.example.data.mysql.seeders.usersDemoData
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDataBase() {
    val database: Database = Database.connect(
        url ="jdbc:mysql://localhost:3306/ktorm",
//        driver = "com.mysql.cj.jdbc:Driver",
        user = "root",
        password = ""
    )

    transaction(database) {
        //migrations
        migration1()
        //seeders
        personDemoData()
        usersDemoData()

    }

}