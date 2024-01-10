package com.example.routes

import com.example.data.remote.dto.UserDto
import com.example.data.remote.dto.person.CreatePersonDto
import com.example.data.remote.dto.person.FoundPersonAddressDto
import com.example.data.remote.dto.person.FoundPersonWithAddressDto
import com.example.domain.mappers.mapUserDtoToUserModel
import com.example.domain.model.UserModel
import com.example.domain.repository.PersonRepository
import com.example.domain.repository.UserRepository
import com.example.domain.repository.UserRepositoryImpl
import com.example.util.GenericResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.personRoute() {

    val personRepository = PersonRepository()



    route("/persons"){


        get("/test"){
            call.respondText("Hello World Person Test!")
        }

        post("/register") {
            val personDto: CreatePersonDto = call.receive()

            val savedUser = personRepository.create(personDto)


            if (savedUser != null){
                call.respond(
                    HttpStatusCode.OK,
                    GenericResponse(
                        isSuccess = true,
                        data = "user saved"
                    )
                )

            }else{
                call.respond(
                    HttpStatusCode.BadRequest,
                    GenericResponse(
                        isSuccess = false,
                        data = "Error in registering user"
                    )
                )
            }
        }


        get("/all") {
            val personList: List<FoundPersonWithAddressDto> = personRepository.findAll()

            if (personList != null){
                call.respond(
                    HttpStatusCode.OK,
                    GenericResponse(
                        isSuccess = true,
                        data =  personList.toString()
                    )
                )

            }else{
                call.respond(
                    HttpStatusCode.BadRequest,
                    GenericResponse(
                        isSuccess = false,
                        data = "Error in retrieving users"
                    )
                )
            }
        }


        get("/{id}") {
            val found = personRepository.find(call.parameters["id"]?.toInt()!!)
            found?.let { call.respond(it) } ?: call.respond(HttpStatusCode.NotFound)
        }
        delete("/{id}") {
            call.respond(personRepository.delete(call.parameters["id"]?.toInt()!!))
        }
        put("/{id}") {
            call.respond(personRepository.update(call.parameters["id"]?.toInt()!!, call.receive()))
        }


    }
}