package kz.noxiq.chocoexpress.data.menu.mapper

import kz.noxiq.chocoexpress.data.menu.model.RestaurantImageEntity

class RestaurantImageMapper {

    fun map(restaurantImageEntity: RestaurantImageEntity): String = restaurantImageEntity.imageUrl.orEmpty()
}