package org.example.domain.response

data class ShoesResponse (
    val shoesId: Int,
    var shoesName: String,
    var shoesDescription: String,
    var shoesUrl: String,
    var category: String,
)

{
    override fun toString(): String {
        return "$shoesName\n$shoesDescription"
    }
}