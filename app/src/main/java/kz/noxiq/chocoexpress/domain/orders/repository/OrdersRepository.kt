package kz.noxiq.chocoexpress.domain.orders.repository

import kz.noxiq.chocoexpress.data.util.BaseResponse
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.common.Response
import java.lang.Exception

interface OrdersRepository {

    fun getUserOrders(): Response<List<Order>, Exception>
}