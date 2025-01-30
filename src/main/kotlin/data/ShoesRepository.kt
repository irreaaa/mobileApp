package org.example.data

import org.example.data.model.ShoesDTO
import org.example.domain.Request.AddShoesRequest

interface ShoesRepository {
    fun addShoes(addShoesRequest: AddShoesRequest): ShoesDTO
    fun getAllShoes(): List<ShoesDTO>
    fun removeShoes(shoesId: Int): Boolean
    abstract fun ShoesDTO(shoesId: Int, shoesName: String, shoesUrl: String, category: String): ShoesDTO
}