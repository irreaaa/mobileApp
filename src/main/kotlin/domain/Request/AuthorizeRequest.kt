package org.example.domain.Request

data class AuthorizeRequest (
    val email: String,
    val password: String
)