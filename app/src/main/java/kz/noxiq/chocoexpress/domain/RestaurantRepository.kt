package kz.noxiq.chocoexpress.domain

import kz.noxiq.chocoexpress.domain.Restaurant

interface RestaurantRepository
{

    fun getRestaurants(page: Int): List<Restaurant>
}