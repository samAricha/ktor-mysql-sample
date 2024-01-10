package com.example.routes

import com.example.data.remote.dto.UserDto
import com.example.domain.mappers.mapUserDtoToUserModel
import com.example.domain.model.UserModel
import com.example.domain.repository.UserRepository
import com.example.domain.repository.UserRepositoryImpl
//import com.example.data.mysql.DbConnection
import com.example.util.GenericResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.JsonEncoder
//import org.ktorm.database.Database
//import org.ktorm.dsl.insert
import kotlin.math.truncate

fun Route.userRoute() {
//    val db: Database = DbConnection.getDatabaseInstance()


    route("/users"){
        val repository: UserRepository = UserRepositoryImpl()


        get("/test"){
            call.respondText("Hello World User Test!")
        }

        post("/register") {
            val userDto: UserDto = call.receive()
            println("userDto------> $userDto")
            val userModel: UserModel = mapUserDtoToUserModel(userDto)
            println("userModel------> $userModel")
            val savedUser = repository.addUser(userModel)


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
            val usersList = repository.getAllUsers()

            if (usersList != null){
                call.respond(
                    HttpStatusCode.OK,
                    GenericResponse(
                        isSuccess = true,
                        data =  usersList.toString()
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
//            val found = repository.find(call.parameters["id"]?.toInt()!!)
//            found?.let { call.respond(it) } ?: call.respond(HttpStatusCode.NotFound)
        }
        delete("/{id}") {
//            call.respond(repository.delete(call.parameters["id"]?.toInt()!!))
        }
        put("/{id}") {
//            call.respond(repository.update(call.parameters["id"]?.toInt()!!, call.receive()))
        }


    }
}