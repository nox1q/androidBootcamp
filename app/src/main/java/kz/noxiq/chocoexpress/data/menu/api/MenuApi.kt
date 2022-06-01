package kz.noxiq.chocoexpress.data.menu.api

import kz.noxiq.chocoexpress.data.menu.model.MenuWrapperEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MenuApi {
    @GET("menu/{id}")
    fun getMenu(@Path("id") id: Long): Call<MenuWrapperEntity>
}