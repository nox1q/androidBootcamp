package kz.noxiq.chocoexpress.di.modules

import android.view.Menu
import dagger.Module
import dagger.Provides
import kz.noxiq.chocoexpress.data.BASE_URL
import kz.noxiq.chocoexpress.data.auth.AuthSharedPrefs
import kz.noxiq.chocoexpress.data.auth.api.AuthApi
import kz.noxiq.chocoexpress.data.interceptor.HeadersInterceptor
import kz.noxiq.chocoexpress.data.menu.api.MenuApi
import kz.noxiq.chocoexpress.data.orders.api.OrdersApi
import kz.noxiq.chocoexpress.data.restaurant.api.RestaurantsApi
import kz.noxiq.chocoexpress.domain.auth.AuthRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(headersInterceptor: Interceptor) =
        OkHttpClient.Builder()
            .addInterceptor(headersInterceptor)
            .build()

    @Singleton
    @Provides
    fun providesRestaurantsApi(
        retrofit: Retrofit
    ): RestaurantsApi = retrofit.create(RestaurantsApi::class.java)

    @Singleton
    @Provides
    fun providesMenuApi(
        retrofit: Retrofit
    ): MenuApi = retrofit.create(MenuApi::class.java)

    @Singleton
    @Provides
    fun providesAuthApi(
        retrofit: Retrofit
    ): AuthApi = retrofit.create(AuthApi::class.java)

    @Singleton
    @Provides
    fun providesOrdersApi(
        retrofit: Retrofit
    ): OrdersApi = retrofit.create(OrdersApi::class.java)

    @Singleton
    @Provides
    fun providesHeadersInterceptor(
        authSharedPrefs: AuthSharedPrefs
    ): Interceptor = HeadersInterceptor(authSharedPrefs)
}