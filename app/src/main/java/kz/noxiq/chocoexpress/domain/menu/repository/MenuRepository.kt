package kz.noxiq.chocoexpress.domain.menu.repository

import kz.noxiq.chocoexpress.domain.menu.model.Menu
import kz.noxiq.common.Response

interface MenuRepository {

    fun getMenuById(id: Long): Response<Menu, Exception>
}