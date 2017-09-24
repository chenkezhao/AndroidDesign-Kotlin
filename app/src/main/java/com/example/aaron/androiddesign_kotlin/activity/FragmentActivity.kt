package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.fragment.OneFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : BaseActivity(), OneFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        flContainer.apply {
            var oneFragment = OneFragment.newInstance("参数1","参数2")
            var ft = supportFragmentManager.beginTransaction() as FragmentTransaction
            ft.replace(this.id,oneFragment)
            ft.commit()
        }
    }


    /**
     * 通常，您将需要一个片段与另一个片段通信，例如，根据用户事件更改内容。所有片段到片段的通信都是通过相关的Activity完成的。两个片段不应该直接通信。
     */
    override fun onFragmentInteraction(temp: String) {
        tvText?.text = "我是OneFragment，我已经改变了你Activity的UI，哈哈哈..."+temp
    }
}
