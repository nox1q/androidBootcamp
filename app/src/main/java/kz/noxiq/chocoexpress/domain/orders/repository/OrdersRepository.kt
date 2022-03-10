package kz.noxiq.chocoexpress.domain.orders.repository

import kz.noxiq.chocoexpress.domain.menu.model.OrderCreate
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.domain.orders.OrderDetails
import kz.noxiq.common.Response
import java.lang.Exception

interface OrdersRepository {

    fun getUserOrders(): Response<List<Order>, Exception>

    fun postUserOrder(orderCreate: OrderCreate): Response<Unit, Exception>
}