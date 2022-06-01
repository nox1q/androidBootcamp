package kz.noxiq.chocoexpress.data.auth.repository

import kz.noxiq.chocoexpress.data.EMPTY_STRING
import kz.noxiq.chocoexpress.data.auth.AuthSharedPrefs
import kz.noxiq.chocoexpress.data.auth.api.AuthApi
import kz.noxiq.chocoexpress.data.auth.model.AuthResultEntity
import kz.noxiq.chocoexpress.data.auth.model.RegisterResultEntity
import kz.noxiq.chocoexpress.data.util.BaseResponse
import kz.noxiq.chocoexpress.domain.auth.AuthRepository
import kz.noxiq.common.Response
import kz.noxiq.common.network.NullResponseException
import kz.noxiq.common.network.executeCall

class BaseAuthRepository(
    private val authApi: AuthApi,
    private val authSharedPrefs: AuthSharedPrefs
) : AuthRepository {

    override fun authorize(
        email: String,
        password: String
    ): Response<String, Exception> {
        val response: Response<BaseResponse<AuthResultEntity>, Exception> =
            authApi.authorize(email, password).executeCall()

        return when (response) {
            is Response.Success -> {
                val accessToken: String? = response.result.data?.accessToken
                accessToken ?: return Response.Error(NullResponseException())

                Response.Success(accessToken)
            }
            is Response.Error -> response
        }
    }

    override fun getAccessToken(): String {
        return authSharedPrefs.getAuthToken()
    }

    override fun saveAccessToken(accessToken: String) {
        authSharedPrefs.setAuthToken(accessToken)
    }

    override fun isLoggedIn(): Boolean {
        return authSharedPrefs.getAuthToken().isNotBlank()
    }

    override fun register(email: String, password: String): Response<String, Exception> {
        val response: Response<RegisterResultEntity, Exception> =
            authApi.register(email, password).executeCall()
        return when (response) {
            is Response.Success -> Response.Success(EMPTY_STRING)
            is Response.Error -> response
        }
    }
}