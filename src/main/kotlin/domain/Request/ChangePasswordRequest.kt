package org.example.domain.Request

data class ChangePasswordRequest (
    val userId: Int,
    val newPassword: String
)