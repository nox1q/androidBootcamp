package kz.noxiq.chocoexpress.data.restaurant.model

import com.google.gson.annotations.SerializedName

data class RestaurantWrapperEntity(
    @SerializedName("restaurant")
    val restaurantEntity: RestaurantEntity?
)