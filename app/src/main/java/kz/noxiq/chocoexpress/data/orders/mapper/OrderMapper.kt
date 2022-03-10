package kz.noxiq.chocoexpress.data.orders.mapper

import kz.noxiq.chocoexpress.data.DEFAULT_ERROR_ID
import kz.noxiq.chocoexpress.data.DEFAULT_ORDER_STATUS
import kz.noxiq.chocoexpress.data.DEFAULT_PRICE
import kz.noxiq.chocoexpress.data.orders.entity.OrderEntity
import kz.noxiq.chocoexpress.data.restaurant.mapper.RestaurantMapper
import kz.noxiq.chocoexpress.domain.orders.Order

class OrderMapper(
    private val orderDetailsMapper: OrderDetailsMapper,
    private val restaurantMapper: RestaurantMapper
) {

    fun map(orderEntity: OrderEntity) = Order(
        id = orderEntity.id ?: DEFAULT_ERROR_ID,
        totalPrice = orderEntity.totalPrice ?: DEFAULT_PRICE,
        orderStatus = orderEntity.orderStatus ?: DEFAULT_ORDER_STATUS,
        createdAt = orderEntity.createdAt.orEmpty(),
        restaurant = restaurantMapper.map(orderEntity.restaurantDataEntity),
        orderDetailsList = orderEntity.orderDetailsList?.map(orderDetailsMapper::map) ?: emptyList()
    )
}