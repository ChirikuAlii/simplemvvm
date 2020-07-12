package info.chirikualii.simplemvvm.utils

import com.google.gson.Gson
import info.chirikualii.simplemvvm.ApplicationLoader
import info.chirikualii.simplemvvm.data.remote.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by chirikuAlii on 12/07/2020.
 * github.com/chirikualii
 */

object RetrofitInstanceBuilder {

    val RETROFIT_INSTANCE: ApiService by lazy {
             Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClientInstance)
            .build().create(ApiService::class.java)
    }

    private val okHttpClientInstance: OkHttpClient by lazy {
        val client = OkHttpClient.Builder()
        client.addInterceptor(loggingInterceptor)
        client.build()
    }

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }
}