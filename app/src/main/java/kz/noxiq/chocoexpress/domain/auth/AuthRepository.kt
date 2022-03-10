package kz.noxiq.chocoexpress.domain.auth

import kz.noxiq.common.Response

interface AuthRepository {

    fun authorize(email: String, password: String): Response<String, Exception>

    fun getAccessToken(): String

    fun saveAccessToken(accessToken: String)

    fun isLoggedIn(): Boolean

    fun register(email: String, password: String): Response<String, Exception>
}