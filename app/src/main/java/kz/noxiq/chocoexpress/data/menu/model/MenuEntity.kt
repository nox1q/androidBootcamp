package kz.noxiq.chocoexpress.data.menu.model

import com.google.gson.annotations.SerializedName

data class MenuEntity(
    @SerializedName("restaurant_id")
    val restaurantId: Long?,
    @SerializedName("restaurant_name")
    val restaurantName: String?,
    @SerializedName("location")
    val restaurantLocation: String?,
    @SerializedName("restaurant_images")
    val restaurantImageUrls: List<RestaurantImageEntity>?,
    @SerializedName("product_categories")
    val productCategories: List<ProductCategoryEntity>?
)
