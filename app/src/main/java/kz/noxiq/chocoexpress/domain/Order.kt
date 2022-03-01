package kz.noxiq.chocoexpress.domain

data class Order(
    val id: Long,
    val restaurantName: String,
    val sum: Double,
)
