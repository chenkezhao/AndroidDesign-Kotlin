package com.example.aaron.androiddesign_kotlin.activity

// 使用来自主代码集的 R.layout.activity_main
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.adapter.MainMenuRVAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

/**
 * https://developer.android.com/training/index.html
 * Android培训
 */
class MainActivity : BaseActivity() {
    val arrs = arrayOf(
            arrayOf("Fragment Demo", FragmentActivity::class.java),
            arrayOf("SharedPreferences API(应用保存键值集)", SharedPreferencesActivity::class.java),
            arrayOf("AppBarLayout+TabLayout+ViewPager+PagerAdapter", TabLayoutActivity::class.java),
            arrayOf("AppBarLayout+TabLayout+ViewPager+FragmentPagerAdapter", TabLayoutActivity2::class.java),
            arrayOf("ViewPager+FragmentPagerAdapter，启动页面，滚动效果", PagerActivity::class.java),
            arrayOf("Toolbar", ToolbarActivity::class.java),
            arrayOf("Toolbar2", ToolbarActivity2::class.java),
            arrayOf("NavigationDrawerActivity导航抽屉", NavigationDrawerActivity::class.java),
            arrayOf("DrawerLayoutActivity抽屉布局", DrawerLayoutActivity::class.java),
            arrayOf("SlidingPaneLayoutActivity滑动面板", SlidingPaneLayoutActivity::class.java),
            arrayOf("SwipeRefreshLayout", SwipeRefreshLayoutActivity::class.java),
            arrayOf("anko-example\nhttps://github.com/Kotlin/anko-example", AnkoExampleActivity::class.java),
            arrayOf("Animations动画", AnimationsActivity::class.java)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                var intent = Intent(this@MainActivity, it[1] as Class<*>);
                intent.putExtra("title", it[0])
                startActivity(intent)
//                startActivity(Intent(this@MainActivity,FragmentActivity::class.java))
            }
        }

    }

    override fun onStart() {
        super.onStart()
        setUpToolbar()
    }

    private fun setUpToolbar() {
//        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        supportActionBar?.apply {
            setHomeButtonEnabled(false)//置返回键不可用
            setDisplayHomeAsUpEnabled(false)
            subtitle = "https://github.com/chenkezhao/"
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.sign_out) {
            finish()
            true
        } else if(item.itemId == R.id.setting){
            //anko startActivity
//            startActivity<SettingActivity>()
            startActivity<SettingActivity2>("title" to "SETTING")
            true
        }else super.onOptionsItemSelected(item)
    }
}
