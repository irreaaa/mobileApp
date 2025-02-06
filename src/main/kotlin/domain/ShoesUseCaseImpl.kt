package org.example.domain

import org.example.data.ShoesRepository
import org.example.data.model.ShoesDTO
import org.example.domain.Request.AddShoesRequest
import org.example.domain.Request.GetAllFilterShoesRequest
import org.example.domain.Request.GetShoesById
import org.example.domain.Request.UpdateShoesRequest
import org.example.domain.response.ShoesResponse

class ShoesUseCaseImpl(private val shoesRepository: ShoesRepository): ShoesUseCase {
    override fun addShoes(addShoesRequest: AddShoesRequest): ShoesResponse {
        val isUnique = shoesRepository.getAllShoes().filter {
            shoes -> shoes.shoesName == addShoesRequest.shoesName
        }
        if (isUnique.isNotEmpty()) {
            throw IllegalArgumentException("Такое имя уже существует.")
        }
        val newShoes = shoesRepository.addShoes(addShoesRequest)
        return ShoesDtoToShoesResponse(newShoes)
    }

    override fun getAllFilterShoes(getAllFilterShoesRequest: GetAllFilterShoesRequest): List<ShoesResponse> {
        val shoesList = shoesRepository.getAllShoes()

        return shoesList
            .filter { shoes ->
                getAllFilterShoesRequest.shoesName?.let { name ->
                    shoes.shoesName.contains(name, ignoreCase = true)
                } ?: true
            }
            .map { shoes -> shoes.mapToShoesResponse() }
    }

//    override fun getShoesById(getShoesById: GetShoesById): List<ShoesResponse> {
//        val shoesListById = shoesRepository.findShoesById(getShoesById.shoesId)
//        return
//    }

    override fun updateShoes(updateShoesRequest: UpdateShoesRequest): ShoesResponse {
        shoesRepository.findShoesById(updateShoesRequest.shoesId)
            ?: throw IllegalArgumentException("Такого id не существует")
        shoesRepository.removeShoes(updateShoesRequest.shoesId)
        val shoesDTO = shoesRepository.addShoesById(updateShoesRequest)
        return shoesDTO.mapToShoesResponse()
    }

    override fun removeShoesById(shoesId: Int): Boolean {
        return shoesRepository.removeShoes(shoesId)
    }
}