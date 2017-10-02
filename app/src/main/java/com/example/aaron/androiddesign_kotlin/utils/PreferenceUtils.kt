package com.example.aaron.androiddesign_kotlin.utils

import android.content.Context

/**
 * Created by Administrator on 2017/10/2.
 */
class PreferencesUtils(val context: Context) {

    private val prefs by lazy {
        //首选项文件default,私有权限Context.MODE_PRIVATE只有自己可以访问
        context.getSharedPreferences(context.packageName+ "_preferences", Context.MODE_PRIVATE)
    }

    fun isNightMode():Boolean = prefs.getBoolean("spNightMode", false)
}