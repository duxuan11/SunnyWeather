package com.sunnyweather.android.logic.model


import com.google.gson.annotations.SerializedName

//数据模型


//@SerializedName注解的方式，来让JSON字段和Kotlin字段之间建立映射关系
//让GSON的数据formatted_address的值赋值给address


class PlaceResponse(val status: String, val places: List<Place>)

class Place(val name: String, val location: Location, @SerializedName("formatted_address") val address: String)

class Location(val lng: String, val lat: String)