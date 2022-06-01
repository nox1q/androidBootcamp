package kz.noxiq.chocoexpress.data.restaurant.model

import com.google.gson.annotations.SerializedName

data class RestaurantEntity(
    @SerializedName("restaurant_data")
    val restaurantDataEntity: RestaurantDataEntity?,
    @SerializedName("image")
    val imageDataEntity: ImageDataEntity?
)