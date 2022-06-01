package kz.noxiq.chocoexpress.data.restaurant.repository

import kz.noxiq.chocoexpress.data.restaurant.api.RestaurantsApi
import kz.noxiq.chocoexpress.data.restaurant.mapper.RestaurantMapper
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant
import kz.noxiq.chocoexpress.domain.restaurant.RestaurantRepository
import kz.noxiq.common.Response
import kz.noxiq.common.network.executeCall
import java.lang.Exception
import javax.inject.Inject

class BaseRestaurantRepository
@Inject constructor(
    private val restaurantMapper: RestaurantMapper,
    private val restaurantsApi: RestaurantsApi
) : RestaurantRepository {

    override fun getRestaurants(): Response<List<Restaurant>, Exception> {
        val response = restaurantsApi.getRestaurants().executeCall()

        return when (response) {
            is Response.Success -> Response.Success(response.result.map(restaurantMapper::map))
            is Response.Error -> response
        }
    }
}