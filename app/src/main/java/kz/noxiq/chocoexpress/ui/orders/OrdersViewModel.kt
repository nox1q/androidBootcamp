package kz.noxiq.chocoexpress.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.noxiq.chocoexpress.domain.Order
import kz.noxiq.chocoexpress.domain.OrderRepository
import kz.noxiq.chocoexpress.domain.Restaurant
import kz.noxiq.chocoexpress.domain.RestaurantRepository
import javax.inject.Inject

class OrdersViewModel
@Inject constructor(
    private val orderRepository: OrderRepository
) : ViewModel() {

    private val orderLiveData = MutableLiveData<List<Order>>()

    fun getOrdersLiveData(): LiveData<List<Order>> = orderLiveData

    init {
        orderLiveData.postValue(orderRepository.getOrders(1))
    }
}