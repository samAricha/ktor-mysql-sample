package com.example.data.mysql.seeders

import com.example.domain.repository.PersonRepository
import com.example.data.remote.dto.address.CreateAddressDto
import com.example.data.remote.dto.person.CreatePersonDto

fun demoData(){
    val repository = PersonRepository()

    val john = repository.create(CreatePersonDto("John", "Doe", 33))
        repository.addAddress(john, CreateAddressDto(
            "ul. Jana Matejki", "12", "1", "Gdansk", "80-232"
        )
        )
        repository.addAddress(john, CreateAddressDto(
            "ul. Jana Matejki", "13", "1", "Gdansk", "80-232"
        ))
        repository.create(CreatePersonDto("George", "Smith", 34))
        repository.create(CreatePersonDto("Megan", "Miller", 22))
    }
