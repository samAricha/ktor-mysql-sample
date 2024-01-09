package com.example.domain.mappers

import com.example.data.remote.dto.UserDto
import com.example.domain.model.UserModel

fun mapUserDtoToUserModel(userDto: UserDto): UserModel {
    return UserModel(
        first = userDto.first ?: "",
        last = userDto.last ?: "",
        dob = userDto.dob ?: "",
        gender = userDto.gender ?: ""
    )
}

fun mapUserModelToUserDto(userModel: UserModel): UserDto {
    return UserDto(
        first = userModel.first,
        last = userModel.last,
        dob = userModel.dob,
        gender = userModel.gender
    )
}