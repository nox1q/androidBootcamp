package kz.noxiq.common.network

import kz.noxiq.common.Response
import retrofit2.Call
import java.io.IOException

fun <T> Call<T>.executeCall(): Response<T, Exception> {
    return try {
        val response = execute()

        when {
            !response.isSuccessful -> Response.Error(Exception())
            response.code() != 200 -> Response.Error(NetworkErrorException(response.code()))
            response.body() == null -> Response.Error(NullResponseException())
            else -> Response.Success(response.body()!!)
        }
    } catch (e: IOException) {
        Response.Error(e)
    }
}