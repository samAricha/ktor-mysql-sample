package com.example.domain.repository

import com.example.data.mysql.entity.UserEntity
import com.example.domain.model.UserModel
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository{

    private fun resultRowToUserModel(row: ResultRow) = UserModel(
//        userId = row[UserEntity.userId],
        first = row[UserEntity.first],
        last = row[UserEntity.last],
        dob = row[UserEntity.last],
        gender = row[UserEntity.gender],
    )
    override fun getAllUsers(): List<UserEntity> = transaction{
        TODO("Not yet implemented")
    }

    override fun getUser(id: Int): UserEntity? = transaction{
        TODO("Not yet implemented")
    }

    override fun addUser(userModel: UserModel): UserModel? = transaction {
        val insertStatement = UserEntity.insert {
            it[first] = userModel.first
            it[last] = userModel.last
            it[dob] = userModel.dob
            it[gender] = userModel.gender
        }

        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToUserModel)
    }

    override fun removeUser(id: Int): Boolean = transaction{
        TODO("Not yet implemented")
    }

    override fun updateUser(id: Int, draft: UserModel): Boolean = transaction {
        TODO("Not yet implemented")
    }

}