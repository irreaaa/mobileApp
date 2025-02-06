package org.example.ui

import org.example.User
import org.example.domain.Request.AuthorizeRequest
import org.example.domain.Request.ChangePasswordRequest
import org.example.domain.Request.ChangeProfileRequest
import org.example.domain.Request.RegistrationRequest
import org.example.domain.UserUseCase
import org.example.domain.response.UserResponse

class UserUi(private val userUseCase: UserUseCase) {
    var userAuthorizer: UserResponse? = null

    fun authorize() {
        println("Введите почту: ")
        val email = readlnOrNull()
        checkNotNull(email) {
            "Имеил не должен отсутствовать."
        }

        println("Введите пароль: ")
        val password = readlnOrNull()
        checkNotNull(password) {
            "Пароль не должен отсутствовать."
        }
        val authorizeRequest = AuthorizeRequest(
            email = email,
            password = password, )
        val user = userUseCase.authorize(authorizeRequest)
        userAuthorizer = user

        println(UserResponseToString(user))
    }

    fun registration() {
        println("Введите имя: ")
        val firstName = readlnOrNull()
        checkNotNull(firstName) {
            "Имя не должен отсутствовать."
        }
        println("Введите почту: ")
        val email = readlnOrNull()
        checkNotNull(email) {
            "Имеил не должен отсутствовать."
        }
        println("Введите пароль")
        val password = readlnOrNull()
        checkNotNull(password) {
            "Пароль не должен отсутствовать."
        }
        val registrationRequest = RegistrationRequest(
            email = email,
            firstName = firstName,
            password = password
        )
        val user = userUseCase.registration(registrationRequest)
        userAuthorizer = user
        UserResponseToString(user)
    }

    fun changePassword() {
        checkNotNull(userAuthorizer){
            "Вы не авторизованы"
        }
        println("Введите новый пароль")
        val password = readlnOrNull()
        checkNotNull(password) {
            "Пароль не должен быть пустым "
        }
        val changePasswordRequest = ChangePasswordRequest(
            userId = userAuthorizer!!.userId,
            newPassword = password
        )
        userUseCase.changePassword(changePasswordRequest)

    }

    fun changeProfile() {
        checkNotNull(userAuthorizer) {
            "Вы не авторизованы"
        }

        var lastName: String? = null
        var phone: String? = null
        var address: String? = null

            println("Введите имеил")
            val email = readlnOrNull()
            checkNotNull(email) {
                "Email не должен быть пустым "
            }

            println("Введите имя")
            val firstName = readlnOrNull()
            checkNotNull(firstName) {
                "Имя не должен быть пустым "
            }

            println("Введите фамилию: ")
            lastName = readlnOrNull()

            println("Введите телефон: ")
            phone = readlnOrNull()

            println("Введите адрес")
            address = readlnOrNull()

        val changeProfileRequest = ChangeProfileRequest(
            userId = userAuthorizer!!.userId,
            newEmail = email,
            newFirstName = firstName,
            newLastName = lastName,
            newPhone = phone,
            newAddress = address,
        )

        val updatedUser = userUseCase.changeProfile(changeProfileRequest)
        userAuthorizer = updatedUser
        println(UserResponseToString(updatedUser))
    }

    fun UserResponseToString(userResponse: UserResponse): String{
        val printOutput = StringBuilder()
        printOutput.append("Ваша почта: ${userResponse.email}")
        printOutput.appendLine()
        printOutput.append("Ваше имя: ${userResponse.firstName}")
        printOutput.appendLine()
        if (!userResponse.lastName.isNullOrBlank()){
            printOutput.append("Ваша фамилия: ${userResponse.lastName}")
            printOutput.appendLine()
        }
        if (!userResponse.phone.isNullOrBlank()){
            printOutput.append("Ваш телефон: ${userResponse.phone}")
            printOutput.appendLine()
        }
        if (!userResponse.address.isNullOrBlank()){
            printOutput.append("Ваш адрес: ${userResponse.address}")
            printOutput.appendLine()
        }
        if(!userResponse.favouriteList.isEmpty()){
            printOutput.appendLine()
            printOutput.append(
                userResponse.favouriteList
                    .map { it.toString() }
                    .joinToString ("\n" )
            )
        }
        return printOutput.toString()
    }
}