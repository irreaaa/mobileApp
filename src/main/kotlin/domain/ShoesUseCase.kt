package org.example.domain

import org.example.domain.Request.AddShoesRequest
import org.example.domain.Request.GetAllFilterShoesRequest
import org.example.domain.Request.GetShoesByIdRequest
import org.example.domain.Request.UpdateShoesRequest
import org.example.domain.response.ShoesResponse

interface ShoesUseCase {
    fun addShoes (addShoesRequest: AddShoesRequest): ShoesResponse
    fun getAllFilterShoes (getAllFilterShoesRequest: GetAllFilterShoesRequest): List<ShoesResponse>
    fun updateShoes(updateShoesRequest: UpdateShoesRequest): ShoesResponse

//    fun getShoesById (getShoesById: GetShoesByIdRequest): List<ShoesResponse>

    fun removeShoesById(shoesId: Int): Boolean
}