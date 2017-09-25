package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import kotlinx.android.synthetic.main.toolbar.*

/**
 *
 * Created by aaron on 2017/9/22.
 */
abstract class BaseActivity : AppCompatActivity() {

    var toolbarTitle: String
        get() = toolbar?.title.toString()
        set(value) {
            toolbar?.title = value
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    open fun setTitle(title: String = "AndroidDesign-Kotlin") {
        toolbarTitle = title
    }

    open fun initBack() {
        enableHomeAsUp { onBackPressed() }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable() = DrawerArrowDrawable(this).apply { progress = 1f }
}