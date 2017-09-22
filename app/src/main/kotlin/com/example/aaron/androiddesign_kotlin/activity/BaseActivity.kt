package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

/**
 *
 * Created by aaron on 2017/9/22.
 */
abstract class BaseActivity : AppCompatActivity(){

    var toolbarTitle: String
        get() = toolbar?.title.toString()
        set(value) {
            toolbar?.title = value
        }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    open fun setTitle(title:String = "AndroidDesign-Kotlin"){
        toolbarTitle = title
    }
}