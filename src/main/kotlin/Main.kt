package org.example

import org.example.data.UserRepositoryImpl
import org.example.domain.UserUseCase
import org.example.domain.UserUseCaseImpl
import org.example.ui.MainMenuUI
import org.example.ui.UserUi

data class User(val number : String,
                var numberInt : Int,
                )

fun main() {
    val userRepository = UserRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository)
    val userUI = UserUi(userUseCase)
//    userUI.registration()
//    userUI.changePassword()
//    userUI.authorize()
//    userUI.changeProfile()
    val mainMenuUI = MainMenuUI(userUI)
    mainMenuUI.displayStartMenu()
}