package kz.noxiq.chocoexpress.ui.home.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.noxiq.chocoexpress.data.DEFAULT_ERROR_ID
import kz.noxiq.chocoexpress.domain.menu.model.*
import kz.noxiq.chocoexpress.domain.menu.repository.MenuRepository
import kz.noxiq.chocoexpress.domain.orders.repository.OrdersRepository
import kz.noxiq.chocoexpress.ui.utils.Event
import kz.noxiq.common.Response
import javax.inject.Inject

class MenuViewModel
@Inject constructor(
    private val menuRepository: MenuRepository,
    private val ordersRepository: OrdersRepository
) : ViewModel() {

    private val menuLiveData = MutableLiveData<Menu>()
    private val productCountUpdateLiveData = MutableLiveData<ProductCountUpdate>()
    private val orderCreateLiveData = MutableLiveData<OrderCreate>()
    private val closeLiveData = MutableLiveData<Event<Unit>>()
    private val positionSizePairLiveData = MutableLiveData<Pair<Int,Int>>()
    private val isLoadingMenu = MutableLiveData<Boolean>()

    private var id: Long = DEFAULT_ERROR_ID

    fun getMenuLiveData(): LiveData<Menu> = menuLiveData
    fun getProductCountUpdateLiveData(): LiveData<ProductCountUpdate> = productCountUpdateLiveData
    fun getOrderCreateLiveData(): LiveData<OrderCreate> = orderCreateLiveData
    fun getCloseLiveData(): LiveData<Event<Unit>> = closeLiveData
    fun getPositionSizePairLiveData(): LiveData<Pair<Int,Int>> = positionSizePairLiveData
    fun getIsLoadingMenu(): LiveData<Boolean> = isLoadingMenu

    fun onStart(id: Long) {
        this.id = id
        loadMenu()
    }

    fun onPageSelected(position: Int) {
        positionSizePairLiveData.value = Pair(position+1,menuLiveData.value?.restaurantImageUrls?.size ?: 0)
    }

    fun onCategoryClicked(position: Int) {

    }

    fun onPayClicked(){

        val orderCreate: OrderCreate = orderCreateLiveData.value ?: return
        viewModelScope.launch {
            val response: Response<Unit, Exception> = withContext(Dispatchers.IO) {
                ordersRepository.postUserOrder(orderCreate)
            }

            when (response){
                is Response.Success -> closeLiveData.value = Event(Unit)
            }
        }

    }

    fun onProductCountChangeClicked(productCountUpdate: ProductCountUpdate) {
        val product: Product = getProduct(productCountUpdate) ?: return
        val orderCreate: OrderCreate = orderCreateLiveData.value ?: return
        val newCount: Int

        if (productCountUpdate.isPlus) {
            newCount = ++product.count
            orderCreate.totalPrice += product.price

            if (product.count == 1) {
                orderCreate.products.add(product)
            }
        } else {
            newCount = --product.count
            orderCreate.totalPrice -= product.price

            if (product.count < 1) {
                orderCreate.products.remove(product)
            }
        }

        productCountUpdate.count = newCount
        productCountUpdateLiveData.value = productCountUpdate
        orderCreateLiveData.value = orderCreate
    }

    private fun getProduct(productCountUpdate: ProductCountUpdate): Product? {
        val productCategories: List<ProductCategory> = menuLiveData.value?.productCategories ?: return null
        val productCategory: ProductCategory = productCategories[productCountUpdate.productCategoryPosition]

        return productCategory.products[productCountUpdate.productPosition]
    }

    private fun loadMenu() {

        isLoadingMenu.value = true
        viewModelScope.launch {
            val response: Response<Menu, Exception> = withContext(Dispatchers.IO) {
                menuRepository.getMenuById(id)
            }

            when (response) {
                is Response.Success -> {
                    val menu: Menu = response.result

                    menuLiveData.value = menu
                    orderCreateLiveData.value = OrderCreate(restaurantId = menu.restaurantId)
                }
                is Response.Error -> Unit
            }
            isLoadingMenu.value = false
        }
    }

}