package kz.noxiq.chocoexpress.data.menu.mapper

import kz.noxiq.chocoexpress.data.DEFAULT_ERROR_ID
import kz.noxiq.chocoexpress.data.menu.model.ProductCategoryEntity
import kz.noxiq.chocoexpress.domain.menu.model.ProductCategory

class ProductCategoryMapper(private val productMapper: ProductMapper) {

    fun map(productCategoryEntity: ProductCategoryEntity) = ProductCategory(
        id = productCategoryEntity.id ?: DEFAULT_ERROR_ID,
        name = productCategoryEntity.name.orEmpty(),
        products = productCategoryEntity.products?.map(productMapper::map).orEmpty()
    )
}