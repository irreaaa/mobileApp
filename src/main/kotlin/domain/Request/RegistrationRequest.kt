package org.example.domain.Request

data class RegistrationRequest (
    val email: String,
    val password: String,
    val firstName: String,
)