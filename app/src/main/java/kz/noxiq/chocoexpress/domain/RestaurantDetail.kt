package kz.noxiq.chocoexpress.domain

data class RestaurantDetail(
    val id: String,
    val name: String,
    val address: String,
    val photoUrls: List<String>
)