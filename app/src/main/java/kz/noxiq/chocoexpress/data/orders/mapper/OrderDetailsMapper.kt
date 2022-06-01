package kz.noxiq.chocoexpress.data.orders.mapper

import kz.noxiq.chocoexpress.data.DEFAULT_ERROR_ID
import kz.noxiq.chocoexpress.data.DEFAULT_QUANTITY
import kz.noxiq.chocoexpress.data.orders.entity.OrderDetailsEntity
import kz.noxiq.chocoexpress.domain.orders.OrderDetails

class OrderDetailsMapper {

    fun map(orderDetailsEntity: OrderDetailsEntity) = OrderDetails(
        productId = orderDetailsEntity.productId ?: DEFAULT_ERROR_ID,
        quantity = orderDetailsEntity.quantity ?: DEFAULT_QUANTITY
    )
}