package kz.noxiq.chocoexpress.di.modules

import dagger.Module
import dagger.Provides
import kz.noxiq.chocoexpress.data.BaseRestaurantRepository
import kz.noxiq.chocoexpress.data.RestaurantEntityProvider
import kz.noxiq.chocoexpress.data.RestaurantMapper
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

}