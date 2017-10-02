package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_setting2.*

class SettingActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting2)
        //夜间模式开启
        if (SharedPreferencesUtils(this).isNight(SharedPreferencesUtils.KEY_ISNIGHT)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            swNight.isChecked = true
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            swNight.isChecked = false
        }
        var spf: SharedPreferencesUtils = SharedPreferencesUtils(this)
        swNight.apply {
            setOnCheckedChangeListener {
                buttonView, isChecked ->
                if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES && !isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    recreate()
                }else if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_NO && isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    recreate()
                }
                spf.setNight(SharedPreferencesUtils.KEY_ISNIGHT, isChecked)
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }
}
