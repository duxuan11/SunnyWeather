package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//Retrofit构建器
object ServiceCreator {

    private const val BASE_URL = "http://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder() //构建Retrofit对象
        .baseUrl(BASE_URL) //指定请求的根路径 设置网络请求的Url地址
        .addConverterFactory(GsonConverterFactory.create())// 设置数据解析器 Gson数据解析
            //需要添加依赖库 implementation 'com.squareup.retrofit2:converter-gson:2.6.1'
        .build()
    //创建 网络请求接口实例
    //当外部调用retrofit 利用create传入serviceClass
    fun<T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    //reified 将内联函数的类型参数标记为在运⾏时可访问
    //对 发送请求 进行封装
    inline fun <reified T> create(): T = create(T::class.java)
}