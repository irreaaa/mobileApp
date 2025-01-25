package org.example.domain

import org.example.domain.Request.AuthorizeRequest
import org.example.domain.Request.ChangePasswordRequest
import org.example.domain.Request.ChangeProfileRequest
import org.example.domain.Request.RegistrationRequest
import org.example.domain.response.UserResponse

interface UserUseCase {
    fun authorize(authorizeRequest: AuthorizeRequest): UserResponse
    fun registration(registrationRequest: RegistrationRequest): UserResponse
    fun changePassword(changePasswordRequest: ChangePasswordRequest)
    fun changeProfile(changeProfileRequest: ChangeProfileRequest): UserResponse

}