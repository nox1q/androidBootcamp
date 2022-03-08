package kz.noxiq.chocoexpress.domain.restaurant

import kz.noxiq.common.Response
import java.lang.Exception

interface RestaurantRepository {

    fun getRestaurants(): Response<List<Restaurant>, Exception>
}