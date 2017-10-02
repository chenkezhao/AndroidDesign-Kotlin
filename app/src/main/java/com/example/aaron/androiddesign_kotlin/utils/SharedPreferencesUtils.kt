package com.example.aaron.androiddesign_kotlin.utils

import android.content.Context

/**
 *
 * Created by Administrator on 2017/9/24.
 */
class SharedPreferencesUtils(val context: Context) {
    companion object {
        val KEY_ISNIGHT = "is_night"
        val KEY_RECREATE = "recreate"
    }

    val prefs by lazy {
        //首选项文件default,私有权限Context.MODE_PRIVATE只有自己可以访问
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    fun getBoolean(key: String?, default: Boolean = false): Boolean = prefs.getBoolean(key, default)
    fun getInt(key: String?, default: Int = 0): Int = prefs.getInt(key, default)
    fun getLong(key: String?, default: Long = 0): Long = prefs.getLong(key, default)
    fun getFloat(key: String?, default: Float = 0f): Float = prefs.getFloat(key, default)
    fun getString(key: String?, default: String?): String = prefs.getString(key, default)
    fun isNight(key: String?, default: Boolean = false): Boolean = prefs.getBoolean(key, default)
    fun isRecreate(key: String?, default: Boolean = false): Boolean = prefs.getBoolean(key, default)

    fun setBoolean(key: String?, value: Boolean = false) = prefs.edit().putBoolean(key, value).apply()
    fun setInt(key: String?, value: Int = 0) = prefs.edit().putInt(key, value).apply()
    fun setLong(key: String?, value: Long = 0) = prefs.edit().putLong(key, value).apply()
    fun setFloat(key: String?, value: Float = 0f) = prefs.edit().putFloat(key, value).apply()
    fun setString(key: String?, value: String?) = prefs.edit().putString(key, value).apply()
    fun setNight(key: String,value: Boolean) = prefs.edit().putBoolean(key, value).apply()
    fun setRecreate(key: String,value: Boolean) = prefs.edit().putBoolean(key, value).apply()


}