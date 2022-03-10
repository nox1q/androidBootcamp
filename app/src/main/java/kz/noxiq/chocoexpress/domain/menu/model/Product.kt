package kz.noxiq.chocoexpress.domain.menu.model

data class Product(
    val id: Long,
    val name: String,
    val price: Int,
    val description: String,
    val imageUrl: String,
    var count: Int = 0
)