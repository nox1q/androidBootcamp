package kz.noxiq.chocoexpress.data.orders.repository

import kz.noxiq.chocoexpress.data.orders.api.OrdersApi
import kz.noxiq.chocoexpress.data.orders.entity.OrderEntity
import kz.noxiq.chocoexpress.data.orders.entity.OrderWrapperEntity
import kz.noxiq.chocoexpress.data.orders.mapper.OrderMapper
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.domain.orders.repository.OrdersRepository
import kz.noxiq.common.Response
import kz.noxiq.common.network.executeCall
import java.lang.Exception
import javax.inject.Inject

class BaseOrdersRepository
@Inject constructor(
    private val orderMapper: OrderMapper,
    private val ordersApi: OrdersApi
) : OrdersRepository {

    override fun getUserOrders(): Response<List<Order>, Exception> {

        val response = ordersApi.getUserOrders().executeCall()

        return when (response) {
            is Response.Success -> {
                val orders: List<OrderEntity> = response.result.data?.orders ?: emptyList()
                Response.Success(orders.map(orderMapper::map))
            }
            is Response.Error -> response
        }
    }
}