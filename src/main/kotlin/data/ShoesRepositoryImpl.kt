package org.example.data

import org.example.data.model.ShoesDTO
import org.example.domain.Request.AddShoesRequest
import org.example.domain.Request.UpdateShoesRequest

class ShoesRepositoryImpl: ShoesRepository {
    private val shoesSource: MutableList<ShoesDTO> = shoesList.toMutableList()
    override fun addShoes(addShoesRequest: AddShoesRequest): ShoesDTO {
        val newShoes = ShoesDTO(
            shoesId = shoesSource.size + 1,
            shoesName = addShoesRequest.shoesName,
            shoesDescription = addShoesRequest.shoesDescription,
            shoesUrl = addShoesRequest.shoesUrl,
            category = addShoesRequest.category,
        )
        shoesSource.add(newShoes)
        return newShoes
    }

    override fun getAllShoes(): List<ShoesDTO> = shoesSource

    override fun removeShoes(shoesId: Int): Boolean {
        return shoesSource.removeIf { it.shoesId == shoesId }
    }

    override fun findShoesById(shoesId: Int): ShoesDTO? {
        return shoesSource.find { shoes -> shoesId == shoes.shoesId }
    }

    override fun addShoesById(updateShoesRequest: UpdateShoesRequest): ShoesDTO {
        val newShoes = ShoesDTO(
            shoesId = updateShoesRequest.shoesId,
            shoesName = updateShoesRequest.shoesName,
            shoesDescription = updateShoesRequest.shoesDescription,
            shoesUrl = updateShoesRequest.shoesUrl,
            category = updateShoesRequest.category,
        )
        shoesSource.add(newShoes)
        return newShoes
    }
}