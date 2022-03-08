package kz.noxiq.chocoexpress.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.noxiq.chocoexpress.domain.auth.AuthRepository
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.domain.orders.repository.OrdersRepository
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant
import kz.noxiq.common.Response
import javax.inject.Inject

class OrdersViewModel
@Inject
constructor(
    private val authRepository: AuthRepository,
    private val ordersRepository: OrdersRepository
) : ViewModel() {

    private val isLoggedLiveData = MutableLiveData<Boolean>()
    private val ordersLiveData = MutableLiveData<List<Order>>()

    fun getIsLoggedLiveData(): LiveData<Boolean> = isLoggedLiveData
    fun getOrdersLiveData(): LiveData<List<Order>> = ordersLiveData

    fun onStart() {
        val isLogged: Boolean = authRepository.isLoggedIn()
        isLoggedLiveData.value = isLogged

        if (isLogged) {
            loadOrders()
        }
    }

    private fun loadOrders() {

        viewModelScope.launch {
            val response: Response<List<Order>, Exception> = withContext(Dispatchers.IO) {
                ordersRepository.getUserOrders()
            }
            when (response) {
                is Response.Success -> ordersLiveData.value = response.result
                is Response.Error -> Unit
            }
        }
    }
}