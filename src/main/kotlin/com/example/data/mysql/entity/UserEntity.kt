package com.example.data.mysql.entity

import org.jetbrains.exposed.sql.Table


object UserEntity: Table(name = "users") {
    val userId = integer(name = "userId").autoIncrement().uniqueIndex()
    val first = text(name = "first")
    val last = text(name = "last")
    val dob = text(name = "dob")
    val gender = text(name = "gender")
    override val primaryKey = PrimaryKey(userId)

}

