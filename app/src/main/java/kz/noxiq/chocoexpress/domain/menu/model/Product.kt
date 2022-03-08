package kz.noxiq.chocoexpress.domain.menu.model

import com.google.gson.annotations.SerializedName

data class Product(
    val id: Long,
    val name: String,
    val price: Int,
    val description: String,
    val imageUrl: String
)