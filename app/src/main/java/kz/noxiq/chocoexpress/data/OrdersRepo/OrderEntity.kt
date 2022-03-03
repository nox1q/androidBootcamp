package kz.noxiq.chocoexpress.data.OrdersRepo

data class OrderEntity(
    val id: Long,
    val restaurantName: String?,
    val sum: String?,
)