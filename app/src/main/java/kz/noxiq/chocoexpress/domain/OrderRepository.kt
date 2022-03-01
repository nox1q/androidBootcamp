package kz.noxiq.chocoexpress.domain

import kz.noxiq.chocoexpress.domain.Restaurant

interface OrderRepository {

    fun getOrders(page: Int): List<Order>
}