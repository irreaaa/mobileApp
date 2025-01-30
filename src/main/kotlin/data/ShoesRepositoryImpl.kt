package org.example.data

import org.example.data.model.ShoesDTO
import org.example.domain.Request.AddShoesRequest

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

    override fun ShoesDTO(shoesId: Int, shoesName: String, shoesUrl: String, category: String): ShoesDTO {
        TODO("Not yet implemented")
    }
}