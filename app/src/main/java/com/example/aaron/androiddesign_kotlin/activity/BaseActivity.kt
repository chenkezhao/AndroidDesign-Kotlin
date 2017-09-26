package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.view.MenuItem
import com.example.aaron.androiddesign_kotlin.R
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

    override fun onStart() {
        super.onStart()
        setTitle(intent.getStringExtra("title")?:resources.getString(R.string.app_name))
        setSupportActionBar(toolbar)
        initBack()
    }

    open fun setTitle(title: String = "AndroidDesign-Kotlin") {
        toolbarTitle = title
    }

    open fun initBack() {
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(true)
            setHomeButtonEnabled(true)//置返回键可用
            setDisplayHomeAsUpEnabled(true)//返回finish()配合onOptionsItemSelected
        }
//        enableHomeAsUp { onBackPressed() }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            finish()
            true
        } else super.onOptionsItemSelected(item)
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar?.navigationIcon = createUpDrawable()
        toolbar?.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable() = DrawerArrowDrawable(this).apply { progress = 1f }
}