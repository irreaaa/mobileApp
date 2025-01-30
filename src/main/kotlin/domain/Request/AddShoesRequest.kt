package org.example.domain.Request

data class AddShoesRequest (
    val shoesId: Int,
    val shoesName: String,
    val shoesDescription: String,
    val shoesUrl: String,
    val category: String,
)