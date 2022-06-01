package kz.noxiq.chocoexpress.domain.menu.model

data class ProductCategory(
    val id: Long,
    val name: String,
    val products: List<Product>
)