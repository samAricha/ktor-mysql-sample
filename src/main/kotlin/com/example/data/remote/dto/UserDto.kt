package com.example.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val first: String? = null,
    val last: String? = null,
    val gender: String? = null,
    val dob: String? = null
)
