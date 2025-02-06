package org.example.data

import org.example.domain.Request.AddFavouriteRequest

class FavouriteRepositoryImpl: FavouriteRepository {
    override fun getAllFavourites() {
        TODO("Not yet implemented")
    }

    override fun addFavourites(vararg addFavouriteRequest: AddFavouriteRequest) {
        TODO("Not yet implemented")
    }

    override fun removeFavourites() {
        TODO("Not yet implemented")
    }

    override fun getFavouritesByUserId() {
        TODO("Not yet implemented")
    }

    override fun getFavouriteByUserId(userId: Int): IntArray {
        return favouriteList
            .filter { it.userId == userId }
            .map { it.shoesId }
            .toIntArray()
    }
}