package kz.noxiq.chocoexpress.domain.menu.model

data class Menu(
    val restaurantId: Long,
    val restaurantName: String,
    val restaurantLocation: String,
    val restaurantImageUrls: List<String>,
    val productCategories: List<ProductCategory>,
    val productCategoryNames: List<String>
)
