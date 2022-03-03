package kz.noxiq.chocoexpress.di.modules

import dagger.Module
import dagger.Provides
import kz.noxiq.chocoexpress.data.restaurant.BaseRestaurantRepository
import kz.noxiq.chocoexpress.data.OrdersRepo.BaseOrderRepository
import kz.noxiq.chocoexpress.data.OrdersRepo.OrderEntityProvider
import kz.noxiq.chocoexpress.data.OrdersRepo.OrderMapper
import kz.noxiq.chocoexpress.data.restaurant.RestaurantEntityProvider
import kz.noxiq.chocoexpress.data.restaurant.RestaurantMapper
import kz.noxiq.chocoexpress.domain.OrderRepository
import kz.noxiq.chocoexpress.domain.RestaurantRepository
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    fun providesRepository(
        restaurantMapper: RestaurantMapper,
        restaurantEntityProvider: RestaurantEntityProvider
    ): RestaurantRepository =
        BaseRestaurantRepository(
            restaurantMapper,
            restaurantEntityProvider
        )

    @Singleton
    @Provides
    fun providesMapper(): RestaurantMapper = RestaurantMapper()

    @Singleton
    @Provides
    fun providesEntityProvider(): RestaurantEntityProvider = RestaurantEntityProvider()

    @Singleton
    @Provides
    fun providesOrderRepository(
        orderMapper: OrderMapper,
        orderEntityProvider: OrderEntityProvider
    ): OrderRepository = BaseOrderRepository(
        orderMapper,
        orderEntityProvider
    )

    @Singleton
    @Provides
    fun providesOrderMapper(): OrderMapper = OrderMapper()

    @Singleton
    @Provides
    fun providesOrderEntityProvider(): OrderEntityProvider = OrderEntityProvider()

}