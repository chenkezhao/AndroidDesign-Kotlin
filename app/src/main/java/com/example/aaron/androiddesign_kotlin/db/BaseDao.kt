package com.example.aaron.androiddesign_kotlin.db

import com.example.aaron.androiddesign_kotlin.db.dao.DbDataMapper

/**
 *
 * Created by aaron on 2017/9/29.
 */
abstract class BaseDao<T> {
    companion object {
        val database: DatabaseOpenHelper = DatabaseOpenHelper.instance
        val dataMapper: DbDataMapper = DbDataMapper()
    }
}