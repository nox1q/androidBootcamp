package kz.noxiq.chocoexpress.data.menu.model

import com.google.gson.annotations.SerializedName

data class RestaurantImageEntity(
    @SerializedName("image_id")
    val id: Long?,
    @SerializedName("url")
    val imageUrl: String?
)
