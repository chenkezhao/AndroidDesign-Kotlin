package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_setting2.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting2)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = intent.getStringExtra("title")?:resources.getString(R.string.app_name)
            setDisplayShowTitleEnabled(true)
            setHomeButtonEnabled(true)//置返回键可用
            setDisplayHomeAsUpEnabled(true)//返回finish()配合onOptionsItemSelected
        }
        toolbar?.setNavigationOnClickListener {finish()}

        //夜间模式开启
        swNight.isChecked = SharedPreferencesUtils(this).isNight(SharedPreferencesUtils.KEY_ISNIGHT)
        var spf: SharedPreferencesUtils = SharedPreferencesUtils(this)
        swNight.apply {
            setOnCheckedChangeListener {
                buttonView, isChecked ->
                if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES && !isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    recreate()
                    spf.setRecreate(SharedPreferencesUtils.KEY_RECREATE,true)
                }else if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_NO && isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    recreate()
                    spf.setRecreate(SharedPreferencesUtils.KEY_RECREATE,true)
                }else if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM){
                    if(isChecked){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    }else{
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    }
                    recreate()
                    spf.setRecreate(SharedPreferencesUtils.KEY_RECREATE,true)
                }
                spf.setNight(SharedPreferencesUtils.KEY_ISNIGHT, isChecked)
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }
}
