package kz.noxiq.chocoexpress.domain.menu.model

data class ProductCountUpdate(
    val productCategoryPosition: Int,
    val productPosition: Int,
    val isPlus: Boolean,
    var count: Int = 0
)