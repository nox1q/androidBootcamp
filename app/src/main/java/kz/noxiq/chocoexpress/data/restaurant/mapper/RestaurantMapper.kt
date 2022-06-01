package kz.noxiq.chocoexpress.data.restaurant.mapper

import kz.noxiq.chocoexpress.data.DEFAULT_ERROR_ID
import kz.noxiq.chocoexpress.data.EMPTY_STRING
import kz.noxiq.chocoexpress.data.restaurant.model.RestaurantDataEntity
import kz.noxiq.chocoexpress.data.restaurant.model.RestaurantWrapperEntity
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant

class RestaurantMapper {
    fun map(restaurantWrapperEntity: RestaurantWrapperEntity) = Restaurant(
        id = restaurantWrapperEntity.restaurantEntity?.restaurantDataEntity?.id ?: DEFAULT_ERROR_ID,
        name = restaurantWrapperEntity.restaurantEntity?.restaurantDataEntity?.name.orEmpty(),
        address = restaurantWrapperEntity.restaurantEntity?.restaurantDataEntity?.address.orEmpty(),
        imageUrl = restaurantWrapperEntity.restaurantEntity?.imageDataEntity?.photoUrl.orEmpty()
    )

    fun map(restaurantDataEntity: RestaurantDataEntity?) = Restaurant(
        id = restaurantDataEntity?.id ?: DEFAULT_ERROR_ID,
        name = restaurantDataEntity?.name.orEmpty(),
        address = restaurantDataEntity?.address.orEmpty(),
        imageUrl = EMPTY_STRING
    )
}