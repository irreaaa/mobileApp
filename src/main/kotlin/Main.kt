package org.example

import org.example.data.*
import org.example.domain.ShoesUseCaseImpl
import org.example.domain.UserUseCaseImpl
import org.example.ui.MainMenuUI
import org.example.ui.ShoesUi
import org.example.ui.UserUi

data class User(val number : String,
                var numberInt : Int,
                )

fun main() {
    val userRepository = UserRepositoryImpl()
    val favouriteRepository = FavouriteRepositoryImpl()
    val shoesRepository = ShoesRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository, favouriteRepository, shoesRepository)
    val userUI = UserUi(userUseCase)
    val shoesUseCase = ShoesUseCaseImpl(shoesRepository)
//    val shoesUI = ShoesUi(shoesUseCase)
//
//    while flag = true
//    userUI.registration()
//    userUI.changePassword()
//    userUI.authorize()
//    userUI.changeProfile()
    val mainMenuUI = MainMenuUI(userUI)
    mainMenuUI.displayStartMenu()
//    shoesUI.addShoes()
//    shoesUI.getAllFilterShoes()
//    shoesUI.updateShoes()
//    shoesUI.getAllFilterShoes()
//    shoesUI.removeShoesById()
//    shoesUI.getAllFilterShoes()
//    shoesUI.getShoesById()
}
