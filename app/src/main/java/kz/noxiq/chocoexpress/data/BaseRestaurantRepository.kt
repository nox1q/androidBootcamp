package kz.noxiq.chocoexpress.data

import kz.noxiq.chocoexpress.domain.Restaurant
import kz.noxiq.chocoexpress.domain.RestaurantRepository
import javax.inject.Inject


class BaseRestaurantRepository
@Inject constructor(
    private val restaurantMapper: RestaurantMapper,
    private val restaurantEntityProvider: RestaurantEntityProvider
) : RestaurantRepository {

    override fun getRestaurants(page: Int): List<Restaurant> {
        return restaurantEntityProvider.getFakeRestaurantEntities(page)
            .map(restaurantMapper::map)
    }
}