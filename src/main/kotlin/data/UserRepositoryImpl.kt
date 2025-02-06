package org.example.data

import org.example.data.model.FavouriteDTO
import org.example.data.model.UserDTO
import org.example.domain.Request.RegistrationRequest

class UserRepositoryImpl: UserRepository {
    private val userSource: MutableList<UserDTO> = userList.toMutableList()

    override fun addUser(registrationRequest: RegistrationRequest): UserDTO {
        val newUser = UserDTO(
            userId = userSource.size + 1,
            email = registrationRequest.email,
            firstName = registrationRequest.firstName,
            password = registrationRequest.password,
        )
        userSource.add(newUser)
        return newUser
    }

    override fun removeUserById(userId: Int): Boolean {
        return userSource.removeIf { it.userId == userId }
    }

    override fun updateUserById(userId: Int, updateUser: UserDTO): UserDTO {
        val oldUser = userSource.firstOrNull() { it.userId == userId }
        checkNotNull(oldUser)
        oldUser.phone = updateUser.phone
        oldUser.address = updateUser.address
        oldUser.firstName = updateUser.firstName
        oldUser.lastName = updateUser.lastName
        oldUser.password = updateUser.password
        oldUser.email = updateUser.email
        return oldUser
    }

    override fun getAllUser(): List<UserDTO> = userSource

    override fun findUserById(userId: Int): UserDTO {
        val findUser = userSource.firstOrNull { it.userId == userId }
        checkNotNull(findUser)
        return findUser
    }
}