package kz.noxiq.chocoexpress.data.restaurant.api

import kz.noxiq.chocoexpress.data.restaurant.model.RestaurantWrapperEntity
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantsApi {
    @GET("restaurants")
    fun getRestaurants(): Call<List<RestaurantWrapperEntity>>
}