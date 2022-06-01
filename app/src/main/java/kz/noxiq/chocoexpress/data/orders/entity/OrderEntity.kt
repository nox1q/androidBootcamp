package kz.noxiq.chocoexpress.data.orders.entity

import com.google.gson.annotations.SerializedName
import kz.noxiq.chocoexpress.data.restaurant.model.RestaurantDataEntity

data class OrderEntity(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("total")
    val totalPrice: Int?,
    @SerializedName("order_status")
    val orderStatus: Int?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("restaurant")
    val restaurantDataEntity: RestaurantDataEntity?,
    @SerializedName("order_details")
    val orderDetailsList: List<OrderDetailsEntity>?
)