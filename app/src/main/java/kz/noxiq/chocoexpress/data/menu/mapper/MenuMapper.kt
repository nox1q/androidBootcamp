package kz.noxiq.chocoexpress.data.menu.mapper

import kz.noxiq.chocoexpress.data.DEFAULT_ERROR_ID
import kz.noxiq.chocoexpress.data.menu.model.MenuEntity
import kz.noxiq.chocoexpress.domain.menu.model.Menu

class MenuMapper(
    private val productCategoryMapper: ProductCategoryMapper,
    private val restaurantImageMapper: RestaurantImageMapper
) {

    fun map(menuEntity: MenuEntity?) = Menu(
        restaurantId = menuEntity?.restaurantId ?: DEFAULT_ERROR_ID,
        restaurantName = menuEntity?.restaurantName.orEmpty(),
        restaurantLocation = menuEntity?.restaurantLocation.orEmpty(),
        restaurantImageUrls = menuEntity?.restaurantImageUrls?.map(restaurantImageMapper::map).orEmpty(),
        productCategories = menuEntity?.productCategories?.map(productCategoryMapper::map).orEmpty(),
        productCategoryNames = menuEntity?.productCategories?.map {it.name.orEmpty()}.orEmpty()
    )
}