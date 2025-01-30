package org.example.ui

import java.awt.MenuItem

class MainMenuUI(private val userUi: UserUi) {
    val menuItems = listOf(
        "1. Авторизация",
        "2. Регистрация",
        "3. Exit",
    )
    val menuAuthorizedItems = listOf(
        "1. Change password",
        "2. Change profile",
        "3. Exit",
    )
    private fun displayMenuItem(menuItem: () -> Unit){
        try {
            menuItem()
        }
        catch (e: Exception){
            println(e.message)
            userUi.userAuthorizer?.let {
                displaYMenuForAuthorizeUser()
            }
        }
    }

    fun displayStartMenu() {
        println(menuItems.joinToString("\n"))
        val menuPosition = readlnOrNull()?.toIntOrNull()
        if(menuPosition == null) displayStartMenu()
        when(menuPosition) {
            1 -> {
                displayMenuItem {
                    userUi.authorize()
                    displaYMenuForAuthorizeUser()
                }
            }
            2 -> {
                displayMenuItem {
                    userUi.registration()
                    displaYMenuForAuthorizeUser()
                }
            }
            3 -> {
                return
            }
            else -> {
                displayStartMenu()
            }
        }
    }
    fun displaYMenuForAuthorizeUser() {
        println(menuAuthorizedItems.joinToString("\n"))
        val menuPosition = readlnOrNull()?.toIntOrNull()
        if(menuPosition == null) displaYMenuForAuthorizeUser()
        when(menuPosition){
            1 -> {
                displayMenuItem {
                    userUi.changePassword()
                    displaYMenuForAuthorizeUser()
                }
            }
            2 -> {
                displayMenuItem {
                    userUi.changeProfile()
                }
            }
            3 -> {
                return
            }
            else -> displayStartMenu()
        }
    }

}