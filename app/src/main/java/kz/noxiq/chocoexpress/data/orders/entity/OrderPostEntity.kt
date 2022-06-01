package kz.noxiq.chocoexpress.data.orders.entity

import com.google.gson.annotations.SerializedName

data class OrderPostEntity(
    @SerializedName("restaurant_id")
    val restaurantId: Long,
    @SerializedName("products")
    val products: List<OrderDetailsPostEntity>
)
