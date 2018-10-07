package codingtask.ebay.vipgallery.util

import android.content.Context
import android.preference.PreferenceManager

import java.io.IOException
import java.util.HashSet

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Stores Cookies in Preferences
 */
private const val PREF_COOKIES = "PREF_COOKIES"

class AddCookiesInterceptor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        val preferences = PreferenceManager.getDefaultSharedPreferences(context).getStringSet(PREF_COOKIES, HashSet()) as HashSet<String>

        for (cookie in preferences) {
            builder.addHeader("Cookie", cookie)
        }

        return chain.proceed(builder.build())
    }
}