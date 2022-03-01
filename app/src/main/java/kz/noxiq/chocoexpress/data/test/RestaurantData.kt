package kz.noxiq.chocoexpress.data.test

data class RestaurantData(
    val created_at: String,
    val id: Int,
    val location: String,
    val name: String,
    val restaurant_images: List<RestaurantImage>,
    val updated_at: String
)