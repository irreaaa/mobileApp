package org.example.ui

import org.example.domain.Request.AddShoesRequest
import org.example.domain.ShoesUseCase
import org.example.domain.ShoesUseCaseImpl
import org.example.domain.response.ShoesResponse

class ShoesUi(private val shoesUseCase: ShoesUseCase) {
    var shoesAdded: ShoesResponse? = null

    fun addShoes() {
        println("Введите название обуви: ")
        val shoesName = readlnOrNull()
        checkNotNull(shoesName) {
            "Имя не должно отсутствовать."
        }
        println("Введите описание обуви: ")
        val desc = readlnOrNull()
        checkNotNull(desc) {
            "Описание не должно отсутствовать."
        }
        println("Введите url обуви: ")
        val url = readlnOrNull()
        checkNotNull(url) {
            "url не должен отсутствовать."
        }
        println("Введите категорию обуви: ")
        val category = readlnOrNull()
        checkNotNull(category) {
            "Категория не должна отсутствовать."
        }
        val addShoesRequest = AddShoesRequest(
            shoesName = shoesName,
            shoesDescription = desc,
            shoesUrl = url,
            category = category,
        )
        val shoes = shoesUseCase.addShoes(addShoesRequest)
        shoesAdded = shoes
        println(ShoesResponseToString(shoes))
    }

    fun ShoesResponseToString(shoesResponse: ShoesResponse): String{
        val printOutput = StringBuilder()
        printOutput.append("shoesName: ${shoesResponse.shoesName}")
        printOutput.appendLine()
        printOutput.append("shoesDesc: ${shoesResponse.shoesDescription}")
        printOutput.appendLine()
        printOutput.append("shoesUrl: ${shoesResponse.shoesUrl}")
        printOutput.appendLine()
        printOutput.append("category: ${shoesResponse.category}")
        printOutput.appendLine()
        return printOutput.toString()
    }

}