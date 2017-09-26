package com.example.aaron.androiddesign_kotlin.activity

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.fragment.TestFragment
import com.example.aaron.androiddesign_kotlin.helper.replaceFragment
import kotlinx.android.synthetic.main.activity_drawer_layout.*
import kotlinx.android.synthetic.main.activity_toolbar.*

class DrawerLayoutActivity : AppCompatActivity() {

    private val leftMenus = arrayOf("Android", "Kotlin", "Java", "Go lang", "JavaScript", "Html")

    private val mDrawerToggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(
                this, /* host Activity */
                drawerLayout, /* DrawerLayout object */
                toolbar, /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open, /* "open drawer" description */
                R.string.drawer_close/* "close drawer" description */
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_layout)

        selectItem(0)
        //定义toolbar
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
        //左边菜单ListView适配
        leftDrawer.apply {
            adapter = ArrayAdapter<String>(this@DrawerLayoutActivity, android.R.layout.simple_list_item_1, leftMenus)
            setOnItemClickListener { parent, view, position, id ->
                selectItem(position)
            }
        }
    }

    private fun selectItem(position: Int) {
        // Create a new fragment and specify the planet to show based on position
        replaceFragment(R.id.flContainer, /*findFragmentById(R.id.flContainer) ?: */TestFragment.newInstance(leftMenus[position]))
        // Highlight the selected item, update the title, and close the drawer
        leftDrawer.setItemChecked(position, true)
        toolbar?.title = leftMenus[position]
        drawerLayout.closeDrawer(leftDrawer)
    }


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        mDrawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
            if (mDrawerToggle.onOptionsItemSelected(item)) true
            else super.onOptionsItemSelected(item)
}
