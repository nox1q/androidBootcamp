package kz.noxiq.chocoexpress.data.menu.model

import com.google.gson.annotations.SerializedName

data class ProductEntity(
    @SerializedName("product_id")
    val id: Long?,
    @SerializedName("product_name")
    val name: String?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val imageUrl: String?
)
