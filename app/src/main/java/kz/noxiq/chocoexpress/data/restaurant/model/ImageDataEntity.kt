package kz.noxiq.chocoexpress.data.restaurant.model

import com.google.gson.annotations.SerializedName

data class ImageDataEntity(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("photo_url")
    val photoUrl: String?
)