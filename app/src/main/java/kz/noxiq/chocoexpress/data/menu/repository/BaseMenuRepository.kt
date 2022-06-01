package kz.noxiq.chocoexpress.data.menu.repository

import kz.noxiq.chocoexpress.data.menu.api.MenuApi
import kz.noxiq.chocoexpress.data.menu.mapper.MenuMapper
import kz.noxiq.chocoexpress.domain.menu.model.Menu
import kz.noxiq.chocoexpress.domain.menu.repository.MenuRepository
import kz.noxiq.common.Response
import kz.noxiq.common.network.NullResponseException
import kz.noxiq.common.network.executeCall
import java.lang.NullPointerException
import javax.inject.Inject

class BaseMenuRepository
@Inject constructor(
    private val menuMapper: MenuMapper,
    private val menuApi: MenuApi
) : MenuRepository {

    override fun getMenuById(id: Long): Response<Menu, Exception> {
        val response = menuApi.getMenu(id).executeCall()

        return when (response) {
            is Response.Success -> Response.Success(menuMapper.map(response.result.menu))
            is Response.Error -> response
        }
    }
}