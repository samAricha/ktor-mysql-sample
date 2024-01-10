package com.example.data.mysql.model.person

import com.example.data.mysql.model.address.AddressEntity
import com.example.data.mysql.model.address.AddressTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class PersonEntity(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<PersonEntity>(PersonTable)

    var name by PersonTable.name
    var surname by PersonTable.surname
    var age by PersonTable.age
    val addresses by AddressEntity referrersOn AddressTable.personId
}

