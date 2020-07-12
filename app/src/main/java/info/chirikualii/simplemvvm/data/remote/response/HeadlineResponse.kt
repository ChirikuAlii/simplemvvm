package info.chirikualii.simplemvvm.data.remote.response

import com.google.gson.annotations.SerializedName


/**
 * Created by chirikuAlii on 11/07/2020.
 * github.com/chirikualii
 */

data class HeadlineResponse(
    @SerializedName("articles")
    var articles: List<ArticleResponse>?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResults")
    var totalResults: Int?
)