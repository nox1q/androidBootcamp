package kz.noxiq.chocoexpress.data.interceptor

import kz.noxiq.chocoexpress.data.auth.AuthSharedPrefs
import kz.noxiq.chocoexpress.domain.auth.AuthRepository
import okhttp3.Interceptor
import okhttp3.Response

private const val KEY_AUTH = "Authorization"

class HeadersInterceptor(private val authSharedPrefs: AuthSharedPrefs): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val accessToken = authSharedPrefs.getAuthToken()

        val requestBuilder = request.newBuilder()

        if (accessToken.isNotBlank()) {
            requestBuilder.addHeader(KEY_AUTH, "Bearer $accessToken")
        }

        return chain.proceed(requestBuilder.build())
    }
}