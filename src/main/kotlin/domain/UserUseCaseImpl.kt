package org.example.domain

import org.example.data.FavouriteRepository
import org.example.data.ShoesRepository
import org.example.data.UserRepository
import org.example.data.model.UserDTO
import org.example.domain.Request.AuthorizeRequest
import org.example.domain.Request.ChangePasswordRequest
import org.example.domain.Request.ChangeProfileRequest
import org.example.domain.Request.RegistrationRequest
import org.example.domain.response.UserResponse

class UserUseCaseImpl(
    private val userRepository: UserRepository,
    private val favouriteRepository: FavouriteRepository,
    private val shoesRepository: ShoesRepository
    ): UserUseCase
{
    override fun authorize(authorizeRequest: AuthorizeRequest): UserResponse {
        val findUser = userRepository.getAllUser()
            .firstOrNull {
                it.email == authorizeRequest.email
            }
        checkNotNull(findUser){
            "Пользователь с такой почтой не найден."
        }
        require(findUser.password == authorizeRequest.password) {
            "Пароли не совпадают."
        }
        val favourite = favouriteRepository.getFavouriteByUserId(userId = findUser.userId)
        val shoesFavourite = shoesRepository.getAllShoes().filter {it.shoesId in favourite}
        return UserDtoTOUserResponse(findUser, shoesFavourite)
    }


    override fun registration(registrationRequest: RegistrationRequest): UserResponse {
        val isUnique = userRepository.getAllUser().firstOrNull() {
            it.email == registrationRequest.email
        } == null
        require(isUnique) {
            "Такая почта уже существует."
        }
        val newUser = userRepository.addUser(registrationRequest)
        return UserDtoTOUserResponse(newUser)
    }

    override fun changePassword(changePasswordRequest: ChangePasswordRequest) {
        val updateUser = userRepository.findUserById(changePasswordRequest.userId)
        updateUser.password = changePasswordRequest.newPassword
        userRepository.updateUserById(changePasswordRequest.userId, updateUser)
    }

    override fun changeProfile(changeProfileRequest: ChangeProfileRequest): UserResponse {
        val updateUserProfile = userRepository.findUserById((changeProfileRequest.userId))
        if (!changeProfileRequest.newEmail.isNullOrEmpty()) updateUserProfile.email = changeProfileRequest.newEmail
        if (!changeProfileRequest.newFirstName.isNullOrEmpty())updateUserProfile.firstName = changeProfileRequest.newFirstName
        if (!changeProfileRequest.newLastName.isNullOrEmpty())updateUserProfile.lastName = changeProfileRequest.newLastName
        if (!changeProfileRequest.newPhone.isNullOrEmpty())updateUserProfile.phone = changeProfileRequest.newPhone
        if (!changeProfileRequest.newAddress.isNullOrEmpty())updateUserProfile.address = changeProfileRequest.newAddress
        val updatedUser = userRepository.updateUserById(changeProfileRequest.userId, updateUserProfile)

        return UserResponse(updatedUser.userId, updatedUser.firstName, updatedUser.lastName, updatedUser.email,
            updatedUser.phone, updatedUser.address)
    }
}