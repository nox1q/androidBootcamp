package kz.noxiq.chocoexpress.data.menu.model

import com.google.gson.annotations.SerializedName

data class ProductCategoryEntity(
    @SerializedName("product_category_id")
    val id: Long?,
    @SerializedName("product_category_name")
    val name: String?,
    @SerializedName("products")
    val products: List<ProductEntity>?
)
