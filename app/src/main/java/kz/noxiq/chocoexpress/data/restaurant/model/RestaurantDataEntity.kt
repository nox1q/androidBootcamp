package kz.noxiq.chocoexpress.data.restaurant.model

import com.google.gson.annotations.SerializedName

data class RestaurantDataEntity(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("location")
    val address: String?
)