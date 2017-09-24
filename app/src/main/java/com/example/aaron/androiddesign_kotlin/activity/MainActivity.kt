package com.example.aaron.androiddesign_kotlin.activity

// 使用来自主代码集的 R.layout.activity_main
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.adapter.MainMenuRVAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {
    //    var menuArr = arrayOf("菜单一","菜单二","菜单三","...")
    val arrs = arrayOf(
            arrayOf("Fragment Demo", FragmentActivity::class.java),
            arrayOf("SharedPreferences API(应用保存键值集)", SharedPreferencesActivity::class.java))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar()
        mainMenuRv.apply {
            //0.添加线条
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            //1.设置布局管理器
            layoutManager = LinearLayoutManager(this@MainActivity).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            //2.adapter
            adapter = MainMenuRVAdapter(arrs, MainMenuRVAdapter.P_VIEWTYPE_LISTDATA) {
                //Anko提供了简单得多的方式通过reified function来启动一个activity
//                Toast.makeText(this@MainActivity,"${it[0]} Clicked", Toast.LENGTH_LONG).show()
//                startActivity<FragmentActivity>()
                startActivity(Intent(this@MainActivity, it[1] as Class<*>))
//                startActivity(Intent(this@MainActivity,FragmentActivity::class.java))
            }
        }

    }

    private fun setUpToolbar() {
//        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setTitle()
    }
}
