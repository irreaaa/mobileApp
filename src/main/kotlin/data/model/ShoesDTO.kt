package org.example.data.model

import org.example.domain.response.ShoesResponse

data class ShoesDTO (
    val shoesId: Int,
    val shoesName: String,
    val shoesDescription: String,
    val shoesUrl: String,
    val category: String,


    ) {
    fun mapToShoesResponse() : ShoesResponse {
        return ShoesResponse(shoesId, shoesName, shoesDescription, shoesUrl, category)
    }
}