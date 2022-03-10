package kz.noxiq.chocoexpress.ui.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.noxiq.chocoexpress.domain.auth.LoginUseCase
import kz.noxiq.common.Response
import javax.inject.Inject

class RegistrationViewModel
@Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    fun onRegisterClicked(email: String, password: String) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                loginUseCase.executeRegistration(email, password)
            }

            when (response) {
                is Response.Success -> Unit

            }
        }
    }

}