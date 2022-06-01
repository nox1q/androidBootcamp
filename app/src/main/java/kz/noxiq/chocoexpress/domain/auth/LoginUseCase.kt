package kz.noxiq.chocoexpress.domain.auth

import kz.noxiq.common.Response

class LoginUseCase(private val authRepository: AuthRepository) {

    fun execute(email: String, password: String): Response<Unit, Exception> {
        val response: Response<String, Exception> = authRepository.authorize(email, password)

        return when (response) {
            is Response.Success -> {
                authRepository.saveAccessToken(response.result)

                Response.Success(Unit)
            }
            is Response.Error -> response
        }
    }

    fun executeRegistration(email: String, password: String): Response<Unit, Exception> {
        val response: Response<String, Exception> = authRepository.register(email, password)

        return when (response) {
            is Response.Success -> {
                Response.Success(Unit)
            }
            is Response.Error -> response
        }
    }

}