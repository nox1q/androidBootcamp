package kz.noxiq.chocoexpress.data.auth.api

import kz.noxiq.chocoexpress.data.auth.model.AuthResultEntity
import kz.noxiq.chocoexpress.data.auth.model.RegisterResultEntity
import kz.noxiq.chocoexpress.data.util.BaseResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {
    @POST("login")
    fun authorize(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<BaseResponse<AuthResultEntity>>

    @POST("register")
    fun register(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<RegisterResultEntity>
}