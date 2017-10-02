package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.aaron.androiddesign_kotlin.R

/**
 * 夜间模式：
 * http://godcoder.me/2016/07/28/Android%20Material%20Design%E7%B3%BB%E5%88%97%E4%B9%8B%E5%A4%9C%E9%97%B4%E6%A8%A1%E5%BC%8F/
 * https://github.com/loonggg/MaterialDesignDemo
 */
class SettingActivity : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBar()
        addPreferencesFromResource(R.xml.setting_preference)
        findPreference("spNightMode").setOnPreferenceChangeListener { preference, any ->
            //夜间模式开启
            if (any as Boolean) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            recreate()
//                TaskStackBuilder.create(this@SettingActivity)
//                        .addNextIntent(Intent(this@SettingActivity, MainActivity::class.java))
//                        .addNextIntent(this@SettingActivity.intent)
//                        .startActivities()
            true
        }
    }

    private fun initBar() {
        val root = findViewById<View>(android.R.id.list).parent.parent.parent as LinearLayout
        root.fitsSystemWindows = true
        var appBarLayout = LayoutInflater.from(this).inflate(R.layout.settings_toolbar, root, false) as AppBarLayout
        root.addView(appBarLayout, 0) // insert at top
        appBarLayout.findViewById<Toolbar>(R.id.toolbar)?.apply {
            setNavigationOnClickListener {
                finish()
            }
        }
    }
}
