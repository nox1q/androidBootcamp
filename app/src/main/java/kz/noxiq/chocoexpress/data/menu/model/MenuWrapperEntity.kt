package kz.noxiq.chocoexpress.data.menu.model

import com.google.gson.annotations.SerializedName
import kz.noxiq.chocoexpress.data.menu.model.MenuEntity

data class MenuWrapperEntity(
    @SerializedName("data")
    val menu: MenuEntity?
)
