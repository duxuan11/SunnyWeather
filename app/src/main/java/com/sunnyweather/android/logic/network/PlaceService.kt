package com.sunnyweather.android.logic.network

import retrofit2.Call
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.PlaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

/*
* 步骤1：添加Retrofit库的依赖
* 步骤2：创建 接收服务器返回数据的类
* 步骤3：创建 用于描述网络请求的接口
* 步骤4：创建 Retrofit 实例
* */

//网络层代码
interface PlaceService {

    //当调用searchplaces()方法的时候，Retrofit就会自动发起一个GET请求(请求的地址就是参数(彩云app接口地址))//相对路径
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN") //这个是相对路径
    //retrofit2自带的call从服务器上返回的json数据 该方法必须声明成Retrofit中内置的Call类型
    //并通过泛型来指定服务器响应数据应该转成什么对象
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
     //自动解析成PlaceResponse对象
}
