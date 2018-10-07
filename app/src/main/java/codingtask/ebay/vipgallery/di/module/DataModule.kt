package codingtask.ebay.vipgallery.di.module

import android.content.Context
import codingtask.ebay.vipgallery.data.api.GalleryAPI
import codingtask.ebay.vipgallery.util.AddCookiesInterceptor
import codingtask.ebay.vipgallery.util.LiveDataCallAdapterFactory
import codingtask.ebay.vipgallery.util.ReceivedCookiesInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Network module
 */
@Module
class DataModule(context: Context) {

    private val addCookies = AddCookiesInterceptor(context)
    private val receivedCookies = ReceivedCookiesInterceptor(context)

    @Singleton
    @Provides
    fun providesOkHttp(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(addCookies)
            .addInterceptor(receivedCookies)
            .addInterceptor(HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(oktHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .client(oktHttpClient)
            .baseUrl("https://m.mobile.de/svc/a/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()

    @Singleton
    @Provides
    fun provideGalleryService(retrofit: Retrofit): GalleryAPI = retrofit.create(GalleryAPI::class.java)

}