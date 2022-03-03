package kz.noxiq.chocoexpress.data.OrdersRepo

import kz.noxiq.chocoexpress.domain.Order
import kz.noxiq.chocoexpress.domain.OrderRepository
import javax.inject.Inject


class BaseOrderRepository
@Inject constructor(
    private val orderMapper: OrderMapper,
    private val orderEntityProvider: OrderEntityProvider
) : OrderRepository {

    override fun getOrders(page: Int): List<Order> {
        return orderEntityProvider.getFakeOrderEntities(page)
            .map(orderMapper::map)
    }
}