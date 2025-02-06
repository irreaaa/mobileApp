package org.example.data

import org.example.data.model.FavouriteDTO
import org.example.data.model.ShoesDTO
import org.example.data.model.UserDTO

val  shoesList = listOf(
    ShoesDTO(
        shoesId = 1,
        shoesName = "1",
        shoesDescription = "123",
        shoesUrl = "3",
        category = "123" +
                ""
    )
)

val favouriteList = listOf(
    FavouriteDTO(
        1,
        1
    ),
    FavouriteDTO(
        2,
        1
    )
)

val userList = listOf(
    UserDTO(
        userId = 1,
        firstName = "Ira",
        password = "123",
        email = "ira@i.com"
    ),
    UserDTO(
        userId = 2,
        firstName = "Masha",
        password = "456",
        email = "masha@i.com"
    ),
    UserDTO(
        userId = 3,
        firstName = "Varya",
        password = "789",
        email = "varya@i.com"
    )
)