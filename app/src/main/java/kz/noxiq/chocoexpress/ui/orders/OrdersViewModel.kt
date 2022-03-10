package kz.noxiq.chocoexpress.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.noxiq.chocoexpress.domain.auth.AuthRepository
import kz.noxiq.chocoexpress.domain.menu.model.Menu
import kz.noxiq.chocoexpress.domain.menu.model.OrderCreate
import kz.noxiq.chocoexpress.domain.menu.model.Product
import kz.noxiq.chocoexpress.domain.menu.repository.MenuRepository
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.domain.orders.repository.OrdersRepository
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant
import kz.noxiq.chocoexpress.domain.restaurant.RestaurantRepository
import kz.noxiq.common.Response
import javax.inject.Inject

class OrdersViewModel
@Inject
constructor(
    private val authRepository: AuthRepository,
    private val ordersRepository: OrdersRepository,
    private val menuRepository: MenuRepository
) : ViewModel() {

    private val isLoggedLiveData = MutableLiveData<Boolean>()
    private val ordersLiveData = MutableLiveData<List<Order>>()
    private val orderLiveData = MutableLiveData<Order>()
    private val productsLiveData = MutableLiveData<List<Product>>()

    fun getIsLoggedLiveData(): LiveData<Boolean> = isLoggedLiveData
    fun getOrdersLiveData(): LiveData<List<Order>> = ordersLiveData
    fun getOrderLiveData(): LiveData<Order> = orderLiveData
    fun getProductsLiveData(): LiveData<List<Product>> = productsLiveData

    fun onStart() {
        val isLogged: Boolean = authRepository.isLoggedIn()
        isLoggedLiveData.value = isLogged

        if (isLogged) {
            loadOrders()
        }
    }

    fun onOrderClicked(order: Order) {
        orderLiveData.value = order
        loadRestaurantMenu(order.restaurant.id)
    }

    private fun onMenuReceived(menu: Menu) {
        val order: Order = orderLiveData.value ?: return
        val products: MutableList<Product> = mutableListOf()

        for (orderDetail in order.orderDetailsList){
            for (productCategory in menu.productCategories){
                val product = productCategory.products.find {
                    it.id == orderDetail.productId
                } ?: continue
                product.count = orderDetail.quantity
                products.add(product)
            }
        }
        productsLiveData.value = products
    }

    private fun loadRestaurantMenu(restaurantId: Long) {
        viewModelScope.launch {
            val response: Response<Menu, Exception> = withContext(Dispatchers.IO) {
                menuRepository.getMenuById(restaurantId)
            }

            when (response) {
                is Response.Success -> onMenuReceived(response.result)
                is Response.Error -> Unit
            }
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