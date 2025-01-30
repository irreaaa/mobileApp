package org.example.domain

import org.example.domain.Request.AddShoesRequest
import org.example.domain.response.ShoesResponse

interface ShoesUseCase {
    fun addShoes (addShoesRequest: AddShoesRequest): ShoesResponse
}