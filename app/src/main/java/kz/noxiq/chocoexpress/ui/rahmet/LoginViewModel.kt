package kz.noxiq.chocoexpress.ui.rahmet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.noxiq.chocoexpress.domain.auth.LoginUseCase
import kz.noxiq.common.Response
import javax.inject.Inject

class LoginViewModel
@Inject
constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun onLoginClicked(email: String, password: String) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                loginUseCase.execute(email, password)
            }

            when (response) {
                is Response.Success -> Unit

            }
        }
    }
}