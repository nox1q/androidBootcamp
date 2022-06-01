package kz.noxiq.chocoexpress.data.orders.entity

import com.google.gson.annotations.SerializedName

data class OrderWrapperEntity(
    @SerializedName("order")
    val orders: List<OrderEntity>
)