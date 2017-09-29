package com.example.aaron.androiddesign_kotlin.db.model

/**
 *
 * Created by aaron on 2017/9/29.
 */
class constructor(var map: MutableMap<String, Any?>) {
    var _id: Long by map
    var name: String by map
    var photo: String by map

    constructor(name: String, photo: String) : this(HashMap()) {
        this.name = name
        this.photo = photo
    }
}