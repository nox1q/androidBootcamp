package kz.noxiq.chocoexpress.data.orders.entity

import kz.noxiq.chocoexpress.data.restaurant.model.RestaurantDataEntity

data class OrderEntity(
    val id: Long?,
    val totalPrice: Int?,
    val orderStatus: Int?,
    val createdAt: String?,
    val restaurantDataEntity: RestaurantDataEntity?,
    val orderDetailsList: List<OrderDetailsEntity>
)