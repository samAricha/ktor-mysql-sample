package com.example.domain.repository

import com.example.data.mysql.entity.UserEntity
import com.example.domain.model.UserModel

interface UserRepository {

    fun getAllUsers(): List<UserEntity>

    fun getUser(id: Int): UserEntity?

    fun addUser(userModel: UserModel): UserModel?

    fun removeUser(id: Int): Boolean

    fun updateUser(id: Int, draft: UserModel): Boolean

}