package kz.noxiq.chocoexpress.domain.menu.model

data class OrderCreate(
    val restaurantId: Long,
    val products: MutableList<Product> = mutableListOf(),
    var totalPrice: Int = 0
)