package kz.noxiq.chocoexpress.data.orders.entity

import com.google.gson.annotations.SerializedName

data class OrderDetailsPostEntity(
    @SerializedName("id")
    val productId: Long?,
    @SerializedName("quantity")
    val quantity: Int?
)