package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
//由于从modelview层就不再持有activity的引用，因此在其它层调用context就容易缺少context情况
//全局获取对象context 要修改androidmanifest文件的name为.SunnyWeatherApplication
//使得先初始化该类
/* Android提供了一个Application类，每当应用程序启动的时候，系统会自动将这个类进行初始化
   而我们可以定制一个自己的Application类，以便于管理程序内一些全局的状态信息，如全局Context
* */
class SunnyWeatherApplication : Application(){

   companion object {  //静态变量
       //将context设置成静态变量容易产生内存泄漏问题，但是我们获取的是application的context而不是activity或者service中的context
       @SuppressLint("StaticFieldLeak")
       lateinit var context: Context
       //你获取的令牌
       const val TOKEN = "wdwlxvuz3FsYwXPH"
   }
    /*Kotlin弱化了静态方法，使用了单例类
    * */

    override fun onCreate() {
        super.onCreate()
//        If your singleton needs a global context (for example to register broadcast receivers), include
//        Context.getApplicationContext() as a android.content.Context argument when invoking your singleton's getInstance() method
        context = applicationContext
    }
}