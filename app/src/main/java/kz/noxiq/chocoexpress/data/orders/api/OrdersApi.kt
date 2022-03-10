package kz.noxiq.chocoexpress.data.orders.api

import kz.noxiq.chocoexpress.data.orders.entity.OrderPostEntity
import kz.noxiq.chocoexpress.data.orders.entity.OrderWrapperEntity
import kz.noxiq.chocoexpress.data.util.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface OrdersApi {

    @GET("orders")
    fun getUserOrders(): Call<BaseResponse<OrderWrapperEntity>>

    @POST("orders")
    fun postUserOrder(@Body orderPostEntity: OrderPostEntity): Call<Any>
}