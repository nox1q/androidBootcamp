package kz.noxiq.chocoexpress.data.OrdersRepo

import kz.noxiq.chocoexpress.domain.Order

class OrderMapper {

    fun map(orderEntity: OrderEntity) = Order(
        id = orderEntity.id,
        restaurantName = orderEntity.restaurantName.orEmpty(),
        sum = orderEntity.sum.orEmpty(),
    )
}