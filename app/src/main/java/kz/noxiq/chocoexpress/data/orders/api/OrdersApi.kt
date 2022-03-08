package kz.noxiq.chocoexpress.data.orders.api

import kz.noxiq.chocoexpress.data.orders.entity.OrderWrapperEntity
import kz.noxiq.chocoexpress.data.util.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface OrdersApi {

    @GET("orders")
    fun getUserOrders(): Call<BaseResponse<OrderWrapperEntity>>
}