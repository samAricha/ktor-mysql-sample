package com.example.domain.repository

import com.example.data.mysql.entity.UserEntity
import com.example.domain.model.UserModel
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository{

    private fun resultRowToUserModel(row: ResultRow) = UserModel(
//        userId = row[UserEntity.userId],
        first = row[UserEntity.first],
        last = row[UserEntity.last],
        dob = row[UserEntity.last],
        gender = row[UserEntity.gender],
    )
    override fun getAllUsers(): List<UserModel> = transaction{
        UserEntity.selectAll().map(::resultRowToUserModel)
    }

    override fun getUser(id: Int): UserModel? = transaction{
        UserEntity
            .selectAll().where { UserEntity.userId eq id }
            .map(::resultRowToUserModel)
            .singleOrNull()
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

    override fun updateUser(id: Int, userModel: UserModel): Boolean= transaction {
        UserEntity.update({ UserEntity.userId eq id }) {
            it[UserEntity.first] = userModel.first
            it[UserEntity.last] = userModel.last
            it[UserEntity.dob] = userModel.dob
            it[UserEntity.gender] = userModel.gender
        } > 0
    }

}