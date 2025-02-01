package org.example.data

import org.example.data.model.ShoesDTO
import org.example.domain.Request.AddShoesRequest
import org.example.domain.Request.UpdateShoesRequest

interface ShoesRepository {
    fun addShoes(addShoesRequest: AddShoesRequest): ShoesDTO
    fun getAllShoes(): List<ShoesDTO>
    fun removeShoes(shoesId: Int): Boolean
    fun findShoesById(shoesId: Int): ShoesDTO?
    fun addShoesById(updateShoesRequest: UpdateShoesRequest): ShoesDTO
}