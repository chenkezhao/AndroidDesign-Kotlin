package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.view.MenuItem
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.utils.SharedPreferencesUtils
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
        //夜间模式开启
//        if (PreferencesUtils(this).isNightMode()) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
        //夜间模式开启
        if (SharedPreferencesUtils(this).isNight(SharedPreferencesUtils.KEY_ISNIGHT)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun onStart() {
        super.onStart()
        setTitle(intent.getStringExtra("title")?:resources.getString(R.string.app_name))
        setSupportActionBar(toolbar)
        initBack()
        //夜间模式开启
        if(SharedPreferencesUtils(this).isRecreate(SharedPreferencesUtils.KEY_RECREATE)){
            recreate()
            SharedPreferencesUtils(this).setRecreate(SharedPreferencesUtils.KEY_RECREATE,false)
        }
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