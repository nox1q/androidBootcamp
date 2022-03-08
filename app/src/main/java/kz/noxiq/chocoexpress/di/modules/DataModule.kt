package kz.noxiq.chocoexpress.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import kz.noxiq.chocoexpress.data.auth.AuthSharedPrefs
import kz.noxiq.chocoexpress.data.auth.api.AuthApi
import kz.noxiq.chocoexpress.data.auth.repository.BaseAuthRepository
import kz.noxiq.chocoexpress.data.menu.api.MenuApi
import kz.noxiq.chocoexpress.data.menu.mapper.MenuMapper
import kz.noxiq.chocoexpress.data.menu.mapper.ProductCategoryMapper
import kz.noxiq.chocoexpress.data.menu.mapper.ProductMapper
import kz.noxiq.chocoexpress.data.menu.mapper.RestaurantImageMapper
import kz.noxiq.chocoexpress.data.menu.repository.BaseMenuRepository
import kz.noxiq.chocoexpress.data.orders.api.OrdersApi
import kz.noxiq.chocoexpress.data.orders.mapper.OrderDetailsMapper
import kz.noxiq.chocoexpress.data.orders.mapper.OrderMapper
import kz.noxiq.chocoexpress.data.orders.repository.BaseOrdersRepository
import kz.noxiq.chocoexpress.data.restaurant.repository.BaseRestaurantRepository
import kz.noxiq.chocoexpress.data.restaurant.mapper.RestaurantMapper
import kz.noxiq.chocoexpress.data.restaurant.api.RestaurantsApi
import kz.noxiq.chocoexpress.domain.auth.AuthRepository
import kz.noxiq.chocoexpress.domain.auth.LoginUseCase
import kz.noxiq.chocoexpress.domain.menu.repository.MenuRepository
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.domain.orders.repository.OrdersRepository
import kz.noxiq.chocoexpress.domain.restaurant.RestaurantRepository
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    fun providesAuthSharedPrefs(app: Application): AuthSharedPrefs = AuthSharedPrefs(app)

    @Singleton
    @Provides
    fun providesRestaurantMapper(): RestaurantMapper = RestaurantMapper()

    @Singleton
    @Provides
    fun providesRestaurantImageMapper(): RestaurantImageMapper = RestaurantImageMapper()

    @Singleton
    @Provides
    fun providesProductMapper(): ProductMapper = ProductMapper()

    @Singleton
    @Provides
    fun providesOrderDetailsMapper(): OrderDetailsMapper = OrderDetailsMapper()

    @Singleton
    @Provides
    fun providesOrderMapper(
        restaurantMapper: RestaurantMapper,
        orderDetailsMapper: OrderDetailsMapper

    ): OrderMapper = OrderMapper(orderDetailsMapper, restaurantMapper)

    @Singleton
    @Provides
    fun providesProductCategoryMapper(
        productMapper: ProductMapper
    ): ProductCategoryMapper =
        ProductCategoryMapper(productMapper)

    @Singleton
    @Provides
    fun providesMenuMapper(
        restaurantImageMapper: RestaurantImageMapper,
        productCategoryMapper: ProductCategoryMapper
    ): MenuMapper = MenuMapper(productCategoryMapper, restaurantImageMapper)


    @Singleton
    @Provides
    fun providesMenuRepository(
        menuMapper: MenuMapper,
        menuApi: MenuApi
    ): MenuRepository = BaseMenuRepository(menuMapper, menuApi)

    @Singleton
    @Provides
    fun providesRestaurantRepository(
        restaurantMapper: RestaurantMapper,
        restaurantsApi: RestaurantsApi
    ): RestaurantRepository = BaseRestaurantRepository(restaurantMapper, restaurantsApi)

    @Singleton
    @Provides
    fun providesOrdersRepository(
        orderMapper: OrderMapper,
        ordersApi: OrdersApi
    ): OrdersRepository = BaseOrdersRepository(orderMapper, ordersApi)

    @Singleton
    @Provides
    fun providesAuthRepository(
        authApi: AuthApi,
        authSharedPrefs: AuthSharedPrefs
    ): AuthRepository = BaseAuthRepository(authApi, authSharedPrefs)

    @Singleton
    @Provides
    fun providesLoginUseCase(
        authRepository: AuthRepository
    ): LoginUseCase = LoginUseCase(authRepository)
}