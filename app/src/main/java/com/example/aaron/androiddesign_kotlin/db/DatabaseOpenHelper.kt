package com.example.aaron.androiddesign_kotlin.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.aaron.androiddesign_kotlin.App
import org.jetbrains.anko.db.*

/**
 * 两种方式调用：
 * 1.val dbHelper1 = DatabaseOpenHelper() // 它会使用 App.instance
 * 2.val dbHelper2 = DatabaseOpenHelper(mockedContext) // 比如，提供给测试tests
 *
 * Created by aaron on 2017/9/29.
 */
class DatabaseOpenHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        DatabaseOpenHelper.DB_NAME,
        null,
        DatabaseOpenHelper.DB_VERSION) {
    companion object {
        val DB_NAME = "my.db"
        val DB_VERSION = 1
        val instance:DatabaseOpenHelper by lazy {
            DatabaseOpenHelper()
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        //不允许混合命名和定位的参数
//        db.createTable("Customer", ifNotExists = true,
//                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
//                "name" to TEXT,
//                "photo" to BLOB)

        db.createTable("Customer", true,
                "_id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "name" to TEXT,
                "photo" to BLOB)
        //or

//        db.createTable("Customer",
//                ifNotExists = true,
//                columns = *arrayOf(
//                        "id" to INTEGER + PRIMARY_KEY + UNIQUE,
//                        "name" to TEXT,
//                        "photo" to BLOB
//                )
//        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("User", true)
    }
}

// Access property for Context
val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.instance