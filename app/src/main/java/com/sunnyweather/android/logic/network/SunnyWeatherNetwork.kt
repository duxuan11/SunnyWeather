package com.sunnyweather.android.logic.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//定义一个统一的网络数据源访问入口，对所有的网络请求的API进行封装
object SunnyWeatherNetwork {
    private val placeService = ServiceCreator.create<PlaceService>()

    //动态代理对象
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    //定义成Call对象的扩展函数，这样所有返回值是Call类型的Retrofit网络请求接口都可以直接调用await()函数
    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine {
            continuation -> enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>,response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }
            override fun onFailure(call: Call<T>, t: Throwable){
                continuation.resumeWithException(t)
            }
        })
        }
    }
}