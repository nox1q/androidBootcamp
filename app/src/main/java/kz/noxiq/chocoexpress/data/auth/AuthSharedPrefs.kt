package kz.noxiq.chocoexpress.data.auth

import android.content.Context
import android.content.SharedPreferences

private const val PREFS_ACCESS_TOKEN = "prefs_access_token"

class AuthSharedPrefs(private val context: Context): Preferences {

    private lateinit var shPr: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    init {
        shPr = context.getSharedPreferences("PreferencesImpl", Context.MODE_PRIVATE)
        editor = shPr.edit()
    }

    override fun setAuthToken(appToken: String) {
        editor.putString(PREFS_ACCESS_TOKEN, appToken)
        editor.commit()
    }

    override fun getAuthToken(): String {
        return shPr.getString(PREFS_ACCESS_TOKEN, "").orEmpty()
    }
}