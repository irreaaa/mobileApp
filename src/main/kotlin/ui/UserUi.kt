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
        println("Enter your email: ")
        val email = readlnOrNull()
        checkNotNull(email) {
            "Имеил не должен отсутствовать."
        }

        println("Enter your password")
        val password = readlnOrNull()
        checkNotNull(password) {
            "Пароль не должен отсутствовать."
        }
        val authorizeRequest = AuthorizeRequest(
            email = email,
            password = password, )
        val user = userUseCase.authorize(authorizeRequest)
        println(UserResponseToString(user))
    }

    fun registration() {
        println("Enter your first name: ")
        val firstName = readlnOrNull()
        checkNotNull(firstName) {
            "Name не должен отсутствовать."
        }
        println("Enter your email: ")
        val email = readlnOrNull()
        checkNotNull(email) {
            "Имеил не должен отсутствовать."
        }
        println("Enter your password")
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
        println("Enter your password")
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

            println("Enter your email")
            val email = readlnOrNull()
            checkNotNull(email) {
                "Email не должен быть пустым "
            }

            println("Enter your first name")
            val firstName = readlnOrNull()
            checkNotNull(firstName) {
                "First name не должен быть пустым "
            }


        if (userAuthorizer!!.lastName != null) {
            println("Enter your last name")
            lastName = readlnOrNull()
        }

        if (userAuthorizer!!.phone != null) {
            println("Enter your phone")
            phone = readlnOrNull()
        }

        if (userAuthorizer!!.address != null) {
            println("Enter your address")
            address = readlnOrNull()
        }

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
            printOutput.append("Ващ адрес: ${userResponse.address}")
            printOutput.appendLine()
        }
        return printOutput.toString()
    }
}