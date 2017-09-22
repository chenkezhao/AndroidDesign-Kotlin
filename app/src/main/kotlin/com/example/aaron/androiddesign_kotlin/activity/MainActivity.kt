package com.example.aaron.androiddesign_kotlin.activity

// 使用来自主代码集的 R.layout.activity_main
import android.os.Bundle
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.adapter.MainMenuAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {
    var menuArr = arrayOf("菜单一","菜单二","菜单三","...")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpToolbar()
        mainMenuLv.apply {
            adapter = MainMenuAdapter(this@MainActivity,menuArr)
        }

    }

    private fun setUpToolbar(){
//        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setTitle()
    }
}
