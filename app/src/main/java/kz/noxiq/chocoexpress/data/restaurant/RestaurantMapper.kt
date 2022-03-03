package kz.noxiq.chocoexpress.data.restaurant

import kz.noxiq.chocoexpress.domain.Restaurant

class RestaurantMapper {

    fun map(restaurantEntity: RestaurantEntity) = Restaurant(
        id = restaurantEntity.id ?: DEFAULT_ERROR_ID,
        name = restaurantEntity.name.orEmpty(),
        address = restaurantEntity.address.orEmpty(),
        photoUrl = restaurantEntity.photoUrl.orEmpty()
    )
}