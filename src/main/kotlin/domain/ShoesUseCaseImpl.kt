package org.example.domain

import org.example.data.ShoesRepository
import org.example.domain.Request.AddShoesRequest
import org.example.domain.response.ShoesResponse

class ShoesUseCaseImpl(private val shoesRepository: ShoesRepository) {
    fun addShoes(addShoesRequest: AddShoesRequest) {
        val isUnique = shoesRepository.getAllShoes().firstOrNull() {
            it.shoesName == addShoesRequest.shoesName
        } == null
        require(isUnique) {
            "Такое название уже есть."
        }
        val newShoes = shoesRepository.addShoes(addShoesRequest)
        return ShoesDtoToShoewResponse(newShoes)
    }
}