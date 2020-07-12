package info.chirikualii.simplemvvm

import android.app.Application
import com.google.gson.Gson
import info.chirikualii.simplemvvm.data.local.NewsDb
import info.chirikualii.simplemvvm.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by chirikuAlii on 11/07/2020.
 * github.com/chirikualii
 */

class ApplicationLoader :Application(){

    //don't forget add class ApplicationLoader in AndroidManifest.xml -> android:name=".ApplicationLoader"

    companion object {
        lateinit var newsDb: NewsDb
    }

    override fun onCreate() {
        super.onCreate()
        newsDb = NewsDb.getInstance(this)
    }


}