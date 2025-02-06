package org.example.domain

import org.example.data.model.ShoesDTO
import org.example.data.model.UserDTO
import org.example.domain.response.ShoesResponse
import org.example.domain.response.UserResponse

fun UserDtoTOUserResponse(userDTO: UserDTO, shoesList: List<ShoesDTO> = emptyList()) = UserResponse(
    lastName =  userDTO.lastName,
    firstName = userDTO.firstName,
    email = userDTO.email,
    phone = userDTO.phone,
    userId = userDTO.userId,
    address = userDTO.address,
    favouriteList = shoesList.map(::ShoesDtoToShoesResponse)
)

fun shoesDtoToUserResponse(shoesDTO: ShoesDTO): ShoesResponse{
    return ShoesResponse(
        shoesId = shoesDTO.shoesId,
        shoesName = shoesDTO.shoesName,
        shoesDescription = shoesDTO.shoesDescription,
        shoesUrl = shoesDTO.shoesUrl,
        category = shoesDTO.category,
    )
}

fun ShoesDtoToShoesResponse(shoesDTO: ShoesDTO) = ShoesResponse(
    shoesId = shoesDTO.shoesId,
    shoesName = shoesDTO.shoesName,
    shoesDescription = shoesDTO.shoesDescription,
    shoesUrl = shoesDTO.shoesUrl,
    category = shoesDTO.category,
)