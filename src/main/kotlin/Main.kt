package org.example

import org.example.data.ShoesRepositoryImpl
import org.example.data.UserRepositoryImpl
import org.example.domain.ShoesUseCaseImpl
import org.example.domain.UserUseCaseImpl
import org.example.ui.ShoesUi
import org.example.ui.UserUi

data class User(val number : String,
                var numberInt : Int,
                )

fun main() {
    val userRepository = UserRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository)
    val userUI = UserUi(userUseCase)
    val shoesRepository = ShoesRepositoryImpl()
    val shoesUseCase = ShoesUseCaseImpl(shoesRepository)
    val shoesUI = ShoesUi(shoesUseCase)
userUI.registration()
//    userUI.changePassword()
//    userUI.authorize()
//userUI.changeProfile()
//    val mainMenuUI = MainMenuUI(userUI)
//    mainMenuUI.displayStartMenu()
    shoesUI.addShoes()
}