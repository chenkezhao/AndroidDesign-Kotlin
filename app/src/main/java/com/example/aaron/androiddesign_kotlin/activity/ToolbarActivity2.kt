package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.aaron.androiddesign_kotlin.R

class ToolbarActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar2)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.sign_out) {
            finish()
            true
        } else super.onOptionsItemSelected(item)
    }
}
