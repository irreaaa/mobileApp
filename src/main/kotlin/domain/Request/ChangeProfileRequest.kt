package org.example.domain.Request

data class ChangeProfileRequest(
    val userId: Int,
    val newEmail: String,
    val newFirstName: String,
    val newLastName: String? = null,
    val newPhone: String? = null,
    val newAddress: String? = null,
)
