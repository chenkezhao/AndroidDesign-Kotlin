package com.example.aaron.androiddesign_kotlin

import android.app.Application

/**
 *
 * Created by aaron on 2017/9/29.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}