package com.example.aaron.androiddesign_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
// 使用来自主代码集的 R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.setText("成功了啊！")

    }
}
