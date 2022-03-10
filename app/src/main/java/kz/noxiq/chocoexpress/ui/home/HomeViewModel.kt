package kz.noxiq.chocoexpress.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant
import kz.noxiq.chocoexpress.domain.restaurant.RestaurantRepository
import kz.noxiq.common.Response
import javax.inject.Inject

class HomeViewModel
@Inject constructor(
    private val restaurantRepository: RestaurantRepository
) : ViewModel() {

    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    private val isLoadingRestaurants = MutableLiveData<Boolean>()

    fun getRestaurantsLiveData(): LiveData<List<Restaurant>> = restaurantsLiveData
    fun getIsLoadingRestaurants(): LiveData<Boolean> = isLoadingRestaurants

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        isLoadingRestaurants.value = true
        viewModelScope.launch {
            val response: Response<List<Restaurant>, Exception> = withContext(Dispatchers.IO) {
                restaurantRepository.getRestaurants()
            }
            when (response) {
                is Response.Success -> restaurantsLiveData.value = response.result
                is Response.Error -> Unit
            }
            isLoadingRestaurants.value = false
        }
    }
}