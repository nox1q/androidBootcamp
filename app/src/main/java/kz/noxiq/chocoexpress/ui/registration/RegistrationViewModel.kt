package kz.noxiq.chocoexpress.ui.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.noxiq.chocoexpress.domain.auth.LoginUseCase
import kz.noxiq.chocoexpress.domain.menu.repository.MenuRepository
import javax.inject.Inject

class RegistrationViewModel
@Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    val emailFieldText = MutableLiveData<String>()
    val passwordFieldText = MutableLiveData<String>()

}