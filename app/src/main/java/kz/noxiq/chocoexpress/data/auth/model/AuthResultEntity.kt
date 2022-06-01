package kz.noxiq.chocoexpress.data.auth.model

import com.google.gson.annotations.SerializedName

data class AuthResultEntity(
    @SerializedName("access_token")
    val accessToken: String?
)