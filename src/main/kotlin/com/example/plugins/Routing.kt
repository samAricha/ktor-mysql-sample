package com.example.plugins

import com.example.routes.personRoute
import com.example.routes.userRoute
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/api/test") {
            call.respondText("Hello World Test!")
        }

        userRoute()
        personRoute()

    }
}
