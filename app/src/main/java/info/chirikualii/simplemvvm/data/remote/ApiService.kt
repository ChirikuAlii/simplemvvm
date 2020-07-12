package info.chirikualii.simplemvvm.data.remote

import info.chirikualii.simplemvvm.data.remote.response.HeadlineResponse
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by chirikuAlii on 11/07/2020.
 * github.com/chirikualii
 */

interface ApiService{

    @GET("top-headlines?country=us&apiKey=452a8b968c514facb39fd8fff27381bb")
    suspend fun getHeadlineNews() : Response<HeadlineResponse>
}