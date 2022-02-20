package kz.noxiq.chocoexpress.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.noxiq.chocoexpress.domain.Restaurant
import kz.noxiq.chocoexpress.domain.RestaurantRepository
import javax.inject.Inject

class HomeViewModel
@Inject constructor(
    private val restaurantRepository: RestaurantRepository
) : ViewModel() {

    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    fun getRestaurantsLiveData(): LiveData<List<Restaurant>> = restaurantsLiveData

    init {
        restaurantsLiveData.postValue(restaurantRepository.getRestaurants(1))
    }
}