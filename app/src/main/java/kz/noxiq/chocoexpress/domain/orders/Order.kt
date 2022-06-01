package kz.noxiq.chocoexpress.domain.orders

import kz.noxiq.chocoexpress.domain.restaurant.Restaurant

data class Order(
    val id: Long,
    val totalPrice: Int,
    val orderStatus: Int,
    val createdAt: String,
    val restaurant: Restaurant,
    val orderDetailsList: List<OrderDetails>
)