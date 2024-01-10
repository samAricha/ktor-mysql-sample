package com.example.data.remote.dto.person

import kotlinx.serialization.Serializable

@Serializable
data class CreatePersonDto(
    val name: String,
    val surname: String,
    val age: Int
)
