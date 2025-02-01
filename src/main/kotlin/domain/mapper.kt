package org.example.domain

import org.example.data.model.ShoesDTO
import org.example.data.model.UserDTO
import org.example.domain.response.ShoesResponse
import org.example.domain.response.UserResponse

fun UserDtoTOUserResponse(userDTO: UserDTO) = UserResponse(
    lastName =  userDTO.lastName,
    firstName = userDTO.firstName,
    email = userDTO.email,
    phone = userDTO.phone,
    userId = userDTO.userId,
    address = userDTO.address,
)

fun ShoesDtoToShoewResponse(shoesDTO: ShoesDTO) = ShoesResponse(
    shoesId = shoesDTO.shoesId,
    shoesName = shoesDTO.shoesName,
    shoesDescription = shoesDTO.shoesDescription,
    shoesUrl = shoesDTO.shoesUrl,
    category = shoesDTO.category,
)