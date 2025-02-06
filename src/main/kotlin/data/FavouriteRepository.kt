package org.example.data

import org.example.domain.Request.AddFavouriteRequest

interface FavouriteRepository {
    fun getAllFavourites()
    fun addFavourites(vararg addFavouriteRequest: AddFavouriteRequest)
    fun removeFavourites()
    fun getFavouritesByUserId()
    fun getFavouriteByUserId(userId: Int): Array<Int>
}