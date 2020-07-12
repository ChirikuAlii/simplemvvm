package info.chirikualii.simplemvvm.utils

import retrofit2.Response
import java.lang.StringBuilder


/**
 * Created by chirikuAlii on 11/07/2020.
 * github.com/chirikualii
 */

abstract class StateRepository {

    suspend fun <T : Any> safeApiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val message = StringBuilder()
            message.append("Problem in API \n Error code: ${response.code()}")
            throw Exception(
                message.toString()
            )
        }
    }
}