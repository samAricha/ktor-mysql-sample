package com.example.data.mysql.seeders

import com.example.domain.repository.PersonRepository
import com.example.data.remote.dto.address.CreateAddressDto
import com.example.data.remote.dto.person.CreatePersonDto
import com.example.domain.model.UserModel
import com.example.domain.repository.UserRepositoryImpl

fun personDemoData(){
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

fun usersDemoData(){
    val repository = UserRepositoryImpl()

    repository.addUser(UserModel("John", "Doe", "01-11-1997", "M"))

    repository.addUser(UserModel("George", "Smith", "12-08-1997", "M"))
    repository.addUser(UserModel("Megan", "Miller", "30-03-1997", "F"))
}
