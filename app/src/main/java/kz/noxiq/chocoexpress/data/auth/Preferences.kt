package kz.noxiq.chocoexpress.data.auth

interface Preferences {

    fun setAuthToken(appToken: String)

    fun getAuthToken(): String

}