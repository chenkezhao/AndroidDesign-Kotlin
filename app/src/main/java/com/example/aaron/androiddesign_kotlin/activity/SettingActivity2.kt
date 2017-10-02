package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_setting2.*

class SettingActivity2 : BaseActivity() {
    var isFrist = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting2)
        var spf: SharedPreferencesUtils = SharedPreferencesUtils(this)

        swNight.apply {
            setOnCheckedChangeListener {
                buttonView, isChecked ->
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                spf.setNight(SharedPreferencesUtils.KEY_ISNIGHT, isChecked)
                if (isFrist) {
                    isFrist = false
//                    recreate()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }
}
