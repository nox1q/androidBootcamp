package kz.noxiq.chocoexpress.data.menu.mapper

import kz.noxiq.chocoexpress.data.DEFAULT_ERROR_ID
import kz.noxiq.chocoexpress.data.DEFAULT_PRICE
import kz.noxiq.chocoexpress.data.menu.model.ProductEntity
import kz.noxiq.chocoexpress.domain.menu.model.Product

class ProductMapper {

    fun map(productEntity: ProductEntity) = Product(
        id = productEntity.id ?: DEFAULT_ERROR_ID,
        name = productEntity.name.orEmpty(),
        price = productEntity.price ?: DEFAULT_PRICE,
        description = productEntity.description.orEmpty(),
        imageUrl = productEntity.imageUrl.orEmpty()
    )
}