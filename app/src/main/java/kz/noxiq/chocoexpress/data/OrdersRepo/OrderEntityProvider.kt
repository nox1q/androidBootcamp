package kz.noxiq.chocoexpress.data.OrdersRepo

private const val PAGE_SIZE = 20

class OrderEntityProvider {

    private val fakeOrderEntities: List<OrderEntity> = listOf(
        OrderEntity(1, "Order 1", "1111",),
        OrderEntity(2, "Order 2", "2222",),
        OrderEntity(3, "Order 3", "3333",),
        OrderEntity(4, "Order 4", "4444",),
        OrderEntity(5, "Order 5", "5555",),
        OrderEntity(6, "Order 6", "6666",),
    )

    fun getFakeOrderEntities(page: Int): List<OrderEntity> {
        val toIndex = Math.min(page * PAGE_SIZE, fakeOrderEntities.size)
        val fromIndex = PAGE_SIZE * (page - 1)
        return fakeOrderEntities.subList(fromIndex, toIndex)
    }

}