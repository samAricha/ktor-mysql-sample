package com.example.data.mysql.model.person

import org.jetbrains.exposed.dao.id.IntIdTable

object PersonTable : IntIdTable("persons") {
    val name = text("name")
    val surname = text("surname")
    val age = integer("age")
}
