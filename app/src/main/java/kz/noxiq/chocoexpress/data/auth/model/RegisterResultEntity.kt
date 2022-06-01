package kz.noxiq.chocoexpress.data.auth.model

import com.google.gson.annotations.SerializedName

data class RegisterResultEntity(
    @SerializedName("message")
    val message: String?
)