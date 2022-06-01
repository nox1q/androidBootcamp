package kz.noxiq.chocoexpress.data.util

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: T?
)