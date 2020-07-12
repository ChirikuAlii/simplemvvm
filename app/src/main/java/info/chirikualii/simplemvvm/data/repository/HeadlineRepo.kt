package info.chirikualii.simplemvvm.data.repository

import android.content.Context
import android.util.Log
import info.chirikualii.simplemvvm.ApplicationLoader
import info.chirikualii.simplemvvm.data.local.ArticleDao
import info.chirikualii.simplemvvm.data.local.ArticleEntity
import info.chirikualii.simplemvvm.data.remote.ApiService
import info.chirikualii.simplemvvm.data.remote.response.HeadlineResponse
import info.chirikualii.simplemvvm.utils.RetrofitInstanceBuilder
import info.chirikualii.simplemvvm.utils.StateRepository


/**
 * Created by chirikuAlii on 11/07/2020.
 * github.com/chirikualii
 */

class HeadlineRepo() : StateRepository() {

    suspend fun getHeadlineNewsRemote() : HeadlineResponse {
        return safeApiRequest {
            val result = RetrofitInstanceBuilder.RETROFIT_INSTANCE.getHeadlineNews()
            result.body()?.articles
                ?.map {
                    ArticleEntity(
                        author = it.author,
                        content = it.content,
                        description = it.description,
                        publishedAt = it.publishedAt.toString(),
                        title = it.title,
                        url = it.url,
                        urlToImage = it.urlToImage
                    )
                }
                ?.forEach { articleEntity ->
                    ApplicationLoader.newsDb.articleDao().addArticle(articleEntity)
                }
            result
        }
    }

    suspend fun getHeadlineNewsLocal() :List<ArticleEntity>{
        Log.d(HeadlineRepo::class.java.simpleName,"get local")
        return ApplicationLoader.newsDb.articleDao().getArticle()
    }
}