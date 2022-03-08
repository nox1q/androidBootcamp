package kz.noxiq.chocoexpress.ui.home.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.noxiq.chocoexpress.data.DEFAULT_ERROR_ID
import kz.noxiq.chocoexpress.domain.menu.model.Menu
import kz.noxiq.chocoexpress.domain.menu.repository.MenuRepository
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant
import kz.noxiq.common.Response
import javax.inject.Inject

class MenuViewModel
@Inject constructor(
    private val menuRepository: MenuRepository
) : ViewModel() {

    private val menuLiveData = MutableLiveData<Menu>()
    private val positionLiveData = MutableLiveData<Int>()
    private var id: Long = DEFAULT_ERROR_ID

    fun getMenuLiveData(): LiveData<Menu> = menuLiveData
    fun getPositionLiveData(): LiveData<Int> = positionLiveData

    fun onStart(id: Long) {
        this.id = id
        loadMenu()
    }

    fun onPageSelected(position: Int) {
        positionLiveData.value = position + 1
    }

    fun onCategoryClicked(position: Int) {

    }

    private fun loadMenu() {
        viewModelScope.launch {
            val response: Response<Menu, Exception> = withContext(Dispatchers.IO) {
                menuRepository.getMenuById(id)
            }

            when (response) {
                is Response.Success -> menuLiveData.value = response.result
                is Response.Error -> Unit
            }
        }
    }

}