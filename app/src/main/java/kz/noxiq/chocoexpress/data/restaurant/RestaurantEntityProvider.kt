package kz.noxiq.chocoexpress.data.restaurant

private const val PAGE_SIZE = 20

class RestaurantEntityProvider {

    private val fakeRestaurantEntities: List<RestaurantEntity> = listOf(
        RestaurantEntity(1, "title 1", "address 1", "photoUrl1"),
        RestaurantEntity(2, "title 2", "address 1", "photoUrl1"),
        RestaurantEntity(3, "title 3", "address 1", "photoUrl1"),
        RestaurantEntity(4, "title 4", "address 1", "photoUrl1"),
        RestaurantEntity(5, "title 5", "address 1", "photoUrl1"),
        RestaurantEntity(6, "title 6", "address 1", "photoUrl1"),
    )

    fun getFakeRestaurantEntities(page: Int): List<RestaurantEntity> {
        val toIndex = Math.min(page * PAGE_SIZE, fakeRestaurantEntities.size)
        val fromIndex = PAGE_SIZE * (page - 1)
        return fakeRestaurantEntities.subList(fromIndex, toIndex)
    }

}