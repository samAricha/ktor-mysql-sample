package com.example.data.mysql.model.address

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class AddressEntity(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<AddressEntity>(AddressTable)

    var street by AddressTable.street
    var house by AddressTable.house
    var apartment by AddressTable.apartment
    var city by AddressTable.city
    var postalCode by AddressTable.postalCode
    var personId by AddressTable.personId
}